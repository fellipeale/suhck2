package br.ufpr.ees.suhck2.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ufpr.ees.suhck2.domain.Atendente;
import br.ufpr.ees.suhck2.service.AtendenteService;

@Controller
public class AtendenteController {

	@Autowired
	private AtendenteService atendenteService;
	
	@RequestMapping(value = "/restrict/atendente")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("atendentes", atendenteService.listAll());
		mav.setViewName("restrict/atendente");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/atendente/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("atendente", new Atendente());
		mav.setViewName("restrict/atendente/novo");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/atendente/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {		
		ModelAndView mav = new ModelAndView();
		mav.addObject("atendente", atendenteService.read(id));
		mav.setViewName("restrict/atendente/editar");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/restrict/atendente/gerenciar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("atendente") @Valid Atendente atendente, BindingResult result) {
		
		if (result.hasErrors()) {
			return "restrict/atendente/novo";
		}	
				
		if (atendente.getId() == null) {
			atendenteService.save(atendente);
			
			return "redirect:/restrict/atendente?save_success=1";
		} else {
			atendenteService.edit(atendente);
			
			return "redirect:/restrict/atendente?edit_success=1";
		}
		
	}
	
	@RequestMapping(value = "/restrict/atendente/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		atendenteService.delete(id);
		
		return "redirect:/restrict/atendente?remove_success=1";
	}
	
}
