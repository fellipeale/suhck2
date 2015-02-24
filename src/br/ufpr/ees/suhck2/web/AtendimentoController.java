package br.ufpr.ees.suhck2.web;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ufpr.ees.suhck2.domain.Agendamento;
import br.ufpr.ees.suhck2.domain.Atendimento;
import br.ufpr.ees.suhck2.domain.Medico;
import br.ufpr.ees.suhck2.security.SuhckAuthentication;
import br.ufpr.ees.suhck2.service.AgendamentoService;
import br.ufpr.ees.suhck2.service.AtendimentoService;
import br.ufpr.ees.suhck2.service.SituacaoService;

@Controller
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private SituacaoService situacaoService;
	
	private Agendamento agendamento;
	private List<Atendimento> atendimentos;
	
	@RequestMapping(value = "/restrict/atendimento")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("agendamentos", agendamentoService.listByPrioridadeAndSituacao(situacaoService.findByValor("Em Espera")));
		mav.setViewName("restrict/atendimento");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/atendimento/novo")
	public ModelAndView novo(Principal principal) {
		ModelAndView mav = new ModelAndView();
		agendamento = agendamentoService.getProximoAgendamento();
		mav.addObject("agendamento", agendamento);
		atendimentos = atendimentoService.listByPaciente(agendamento.getPaciente());
		mav.addObject("atendimentos", atendimentos);
		
		Atendimento atendimento = new Atendimento();
		atendimento.setPaciente(agendamento.getPaciente());
		
		if (principal instanceof SuhckAuthentication) {
			atendimento.setMedico((Medico)((SuhckAuthentication) principal).getDetails());
		} else {
			Medico medico = new Medico();
			medico.setNome(principal.getName());
			atendimento.setMedico(medico);
		}
		
		agendamento.setSituacao(situacaoService.findByValor("Em Atendimento"));
		agendamento.setMedico(atendimento.getMedico());
		agendamentoService.edit(agendamento);
		
		mav.addObject("atendimento", atendimento);
		
		mav.setViewName("restrict/atendimento/novo");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/atendimento/gerenciar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("atendimento") @Valid Atendimento atendimento, BindingResult result) {
		
		if (result.hasErrors()) {
			return "restrict/atendimento/novo";
		}	
				
		agendamento.setSituacao(situacaoService.findByValor("Atendido"));
		agendamentoService.edit(agendamento);
		
		atendimento.setDataHora(LocalDateTime.now());
		atendimentoService.save(atendimento);			
		return "redirect:/restrict/atendimento?save_success=1";
	}
	
	@RequestMapping(value = "/restrict/atendimento/cancelar")
	public String cancelar() {				
		agendamento.setSituacao(situacaoService.findByValor("Cancelado"));
		agendamentoService.edit(agendamento);
					
		return "redirect:/restrict/atendimento?cancel_success=1";
	}

	@ModelAttribute("agendamento")
	public Agendamento getAgendamento() {
		return agendamento;
	}

	@ModelAttribute("atendimentos")
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}
		
}
