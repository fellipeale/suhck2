package br.ufpr.ees.suhck2.web;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ufpr.ees.suhck2.domain.Agendamento;
import br.ufpr.ees.suhck2.domain.Atendente;
import br.ufpr.ees.suhck2.domain.Estado;
import br.ufpr.ees.suhck2.domain.Paciente;
import br.ufpr.ees.suhck2.security.SuhckAuthentication;
import br.ufpr.ees.suhck2.service.AgendamentoService;
import br.ufpr.ees.suhck2.service.EstadoService;
import br.ufpr.ees.suhck2.service.PacienteService;
import br.ufpr.ees.suhck2.service.SituacaoService;

@Controller
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private SituacaoService situacaoService;
	
	@RequestMapping(value = "/restrict/agendamento")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("agendamentos", agendamentoService.listAll());
		mav.setViewName("restrict/agendamento");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/agendamento/novo")
	public ModelAndView novo(Principal principal) {
		ModelAndView mav = new ModelAndView();
		
		Agendamento agendamento = new Agendamento();
		agendamento.setDataHora(LocalDateTime.now());
		agendamento.setSituacao(situacaoService.findByValor("Em Espera")); //TODO - Substituir por ENUM
		
		if (principal instanceof SuhckAuthentication) {
			agendamento.setAtendente((Atendente)((SuhckAuthentication) principal).getDetails());
		} else {
			Atendente atendente = new Atendente();
			atendente.setNome(principal.getName());
			agendamento.setAtendente(atendente);
		}
		
		mav.addObject("agendamento", agendamento);
		mav.setViewName("restrict/agendamento/novo");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/agendamento/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {		
		ModelAndView mav = new ModelAndView();
		mav.addObject("agendamento", agendamentoService.read(id));
		mav.setViewName("restrict/agendamento/editar");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/restrict/agendamento/gerenciar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("agendamento") @Valid Agendamento agendamento, BindingResult result) {
		
		if (result.hasErrors()) {
			return "restrict/agendamento/novo";
		}	
				
		if (agendamento.getId() == null) {
			agendamentoService.save(agendamento);
			
			return "redirect:/restrict/agendamento?save_success=1";
		} else {
			agendamentoService.edit(agendamento);
			
			return "redirect:/restrict/agendamento?edit_success=1";
		}
		
	}
	
	@RequestMapping(value = "/restrict/agendamento/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		agendamentoService.delete(id);
		
		return "redirect:/restrict/agendamento?remove_success=1";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Paciente.class, "paciente", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Paciente paciente = null;
				if (!StringUtils.isEmpty(text)) {
					paciente = pacienteService.read(Integer.parseInt(text));
				}
				
				this.setValue(paciente);
			}
		});
		binder.registerCustomEditor(Estado.class, "estado", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Estado estado = null;
				if (!StringUtils.isEmpty(text)) {
					estado = estadoService.read(Integer.parseInt(text));
				}
				
				this.setValue(estado);
			}
		});
	}
	
	@ModelAttribute("pacientes")
	public List<Paciente> getPacientes() {
		return pacienteService.listAll();
	}
	
	@ModelAttribute("estados")
	public List<Estado> getEstados() {
		return estadoService.listAll();
	}
	
}
