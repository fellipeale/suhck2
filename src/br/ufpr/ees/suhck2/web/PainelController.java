package br.ufpr.ees.suhck2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufpr.ees.suhck2.service.AgendamentoService;
import br.ufpr.ees.suhck2.service.SituacaoService;

@Controller
public class PainelController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private SituacaoService situacaoService;
	
	@RequestMapping(value = "/restrict/painel")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("proximoAtendimento", agendamentoService.getProximoAtendimento());
		mav.addObject("agendamentos", agendamentoService.listByPrioridadeAndSituacao(situacaoService.findByValor("Em Espera")));
		mav.setViewName("restrict/painel");
		
		return mav;
	}
	
}
