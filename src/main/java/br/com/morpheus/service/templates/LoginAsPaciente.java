package br.com.morpheus.service.templates;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.morpheus.domain.model.Paciente;
import br.com.morpheus.domain.model.User;
import br.com.morpheus.domain.repository.PacienteRepository;

public class LoginAsPaciente extends LoginUserTemplate {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	
	@Override
	boolean validarPermissao(HttpSession session, User user, String userType) {
		Iterable<Paciente> pacientes = pacienteRepository.findAll();
		
		for (Paciente paciente : pacientes) {
			if (paciente.getUser().getLogin().equals(user.getLogin())) {
				session.setAttribute("userType", paciente);
				return true;
			}
		}	
		return false;
	}


}
