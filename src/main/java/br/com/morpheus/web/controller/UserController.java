package br.com.morpheus.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.morpheus.domain.model.Medico;
import br.com.morpheus.domain.model.Paciente;
import br.com.morpheus.domain.model.User;
import br.com.morpheus.service.CustomService;

@Controller
public class UserController {
	
	@Autowired
	private CustomService customService;

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerUser(User user) {
		customService.addUserAsPaciente(user, new Paciente());
		return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginUser(HttpSession session, String login, String senha, String userType) {
		String redirect = customService.loginUser(session, login, senha, userType);
		return redirect;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutUser(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "formlogin";
	}
	
	/**
	 * Controller para Médico
	 * **/
	@RequestMapping(value="/addPacienteParaMedico")
	public String addPacienteParaMedico(HttpSession session, Paciente paciente) {
		Medico medico = (Medico) session.getAttribute("userType");
		User user = (User) session.getAttribute("userLogado"); 		
		customService.addPacienteParaMedico(medico, user.getLogin(), paciente);		
		return "menu-medico";
	}
	
	/**
	 * Controller para Médico
	 * **/

}
