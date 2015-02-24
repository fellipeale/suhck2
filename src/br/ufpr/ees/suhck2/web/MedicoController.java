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

import br.ufpr.ees.suhck2.domain.Especialidade;
import br.ufpr.ees.suhck2.domain.Medico;
import br.ufpr.ees.suhck2.service.EspecialidadeService;
import br.ufpr.ees.suhck2.service.MedicoService;
import br.ufpr.ees.suhck2.service.PermissaoService;

@Controller
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private EspecialidadeService especialidadeService;
	
	@Autowired
	private PermissaoService permissaoService;
	
	@RequestMapping(value = "/restrict/medico")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("medicos", medicoService.listAll());
		mav.setViewName("restrict/medico");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/medico/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("medico", new Medico());
		mav.setViewName("restrict/medico/novo");
		
		return mav;
	}
	
	@RequestMapping(value = "/restrict/medico/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {		
		ModelAndView mav = new ModelAndView();
		mav.addObject("medico", medicoService.read(id)); //TODO - Exibir erro quando o médico for nulo
		mav.setViewName("restrict/medico/editar");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/restrict/medico/gerenciar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("medico") @Valid Medico medico, BindingResult result) {
		
		if (result.hasErrors()) {
			return "restrict/medico/novo";
		}	
				
		if (medico.getId() == null) {
			medico.setAtivo(true);
			medico.setPermissao(permissaoService.findByValor("ROLE_MEDICO"));
			medicoService.save(medico);
			
			return "redirect:/restrict/medico?save_success=1";
		} else {
			medicoService.edit(medico);
			
			return "redirect:/restrict/medico?edit_success=1";
		}
		
	}
	
	@RequestMapping(value = "/restrict/medico/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		medicoService.delete(id);
		
		return "redirect:/restrict/medico?remove_success=1";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Especialidade.class, "especialidade", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Especialidade especialidade = null;
				if (!StringUtils.isEmpty(text)) {
					especialidade = especialidadeService.read(Integer.parseInt(text));
				}
				
				this.setValue(especialidade);
			}
		});
	}
	
	@ModelAttribute("especialidades")
	public List<Especialidade> getEspecialidades() {
		return especialidadeService.listAll();
	}
	
}
