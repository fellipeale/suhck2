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

import br.ufpr.ees.suhck2.domain.PlanoSaude;
import br.ufpr.ees.suhck2.service.PlanoService;

@Controller
public class PlanoController {

	@Autowired
	private PlanoService planoService;
	
	@RequestMapping(value = "/restrict/plano")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("planos", planoService.listAll());
		mav.setViewName("restrict/plano");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/plano/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("plano", new PlanoSaude());
		mav.setViewName("restrict/plano/novo");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/plano/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("plano", planoService.read(id));
		mav.setViewName("restrict/plano/editar");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/plano/gerenciar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("plano") @Valid PlanoSaude plano, BindingResult result) {
		
		if (result.hasErrors()) {
			return "restrict/plano/novo";
		}	
				
		if (plano.getId() == null) {
			planoService.save(plano);
			
			return "redirect:/restrict/plano?save_success=1";
		} else {
			planoService.edit(plano);
			
			return "redirect:/restrict/plano?edit_success=1";
		}
		
	}
	
	@RequestMapping(value = "/restrict/plano/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		planoService.delete(id);
		
		return "redirect:/restrict/plano?remove_success=1";
	}
	
}
