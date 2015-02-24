package br.ufpr.ees.suhck2.web;

import java.beans.PropertyEditorSupport;
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

import br.ufpr.ees.suhck2.domain.Paciente;
import br.ufpr.ees.suhck2.domain.PlanoSaude;
import br.ufpr.ees.suhck2.domain.TipoPlanoSaude;
import br.ufpr.ees.suhck2.service.PacienteService;
import br.ufpr.ees.suhck2.service.PlanoService;
import br.ufpr.ees.suhck2.service.TipoPlanoSaudeService;

@Controller
public class PacienteController {

	@Autowired
	private PlanoService planoService;
	
	@Autowired
	private TipoPlanoSaudeService tipoPlanoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@RequestMapping(value = "/restrict/paciente")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pacientes", pacienteService.listAll());
		mav.setViewName("restrict/paciente");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/paciente/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("paciente", new Paciente());
		mav.setViewName("restrict/paciente/novo");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/paciente/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("paciente", pacienteService.read(id));
		mav.setViewName("restrict/paciente/editar");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/paciente/gerenciar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("paciente") @Valid Paciente paciente, BindingResult result) {
		
		if (result.hasErrors()) {
			return "restrict/paciente/novo";
		}	
				
		if (paciente.getId() == null) {
			pacienteService.save(paciente);
			
			return "redirect:/restrict/paciente?save_success=1";
		} else {
			pacienteService.edit(paciente);
			
			return "redirect:/restrict/paciente?edit_success=1";
		}
		
	}
	
	@RequestMapping(value = "/restrict/paciente/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		pacienteService.delete(id);
		
		return "redirect:/restrict/paciente?remove_success=1";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(PlanoSaude.class, "planoSaude", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				PlanoSaude planoSaude = null;
				if (!StringUtils.isEmpty(text)) {
					planoSaude = planoService.read(Integer.parseInt(text));
				}
				
				this.setValue(planoSaude);
			}
		});
		
		binder.registerCustomEditor(TipoPlanoSaude.class, "tipoPlanoSaude", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				TipoPlanoSaude tipoPlanoSaude = null;
				if (!StringUtils.isEmpty(text)) {
					tipoPlanoSaude = tipoPlanoService.read(Integer.parseInt(text));
				}
				
				this.setValue(tipoPlanoSaude);
			}
		});
	}
	
	@ModelAttribute("planosSaude")
	public List<PlanoSaude> getPlanosSaude() {
		return planoService.listAll();
	}
	
	@ModelAttribute("tiposPlanoSaude")
	public List<TipoPlanoSaude> getTiposPlanoSaude() {
		return tipoPlanoService.listAll();
	}
	
}
