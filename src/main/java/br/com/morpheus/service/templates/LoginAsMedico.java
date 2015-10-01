package br.com.morpheus.service.templates;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.morpheus.domain.model.Medico;
import br.com.morpheus.domain.model.User;
import br.com.morpheus.domain.repository.MedicoRepository;


public class LoginAsMedico extends LoginUserTemplate {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	boolean validarPermissao(HttpSession session, User user, String userType) {
		
		Iterable<Medico> medicos = medicoRepository.findAll();
		
		for (Medico medico : medicos) {
			if (medico.getUser().getLogin().equals(user.getLogin())) {
				session.setAttribute("userType", medico);
				return true;
			}
		}	
		return false;
	}
}
