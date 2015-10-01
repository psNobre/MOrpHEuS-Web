package br.com.morpheus.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.morpheus.domain.model.User;


@Controller
public class NavigationController {
	
	@RequestMapping("/")
    public String index() {
        return "index";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String paginaInicial(HttpSession session){
		User user = (User)session.getAttribute("userLogado");
		if (user != null) {
			if (session.getAttribute("userTipo").equals("Medico")) {
				return "menu-medico";
			}else {
				return "menu-paciente";
			}	
		}
		return "index";		
	}

	@RequestMapping(value="/formreg", method = RequestMethod.GET)
	public String redirectFormRegister() {
		return "formregister";
	}

	@RequestMapping("/formlog")
	public String redirectFormLogin() {
		return "formlogin";
	}
	
}
