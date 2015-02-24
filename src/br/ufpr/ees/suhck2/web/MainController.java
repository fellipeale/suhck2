package br.ufpr.ees.suhck2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = {"/", "/public/main"})
	public String publicIndex() {
		return "public/main";
	}
	
	@RequestMapping(value = {"/restrict", "/restrict/main"})
	public String restrictIndex() {
		return "restrict/main";
	}
	
}
