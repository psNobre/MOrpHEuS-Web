package br.com.morpheus.service.templates;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.morpheus.domain.model.User;
import br.com.morpheus.domain.repository.UserRepository;



public abstract class LoginUserTemplate {
	@Autowired
	private UserRepository userRepository;

	public boolean executeLoginTemplete(HttpSession session, String login, String senha, String userType){
		
		User user = procurarUserNoBanco(login);
		boolean permissao = validarPermissao(session ,user, userType);
		boolean result = validarParametros(user, senha, permissao);
		addUserInSession(session, user);
		
		return result;
	}

	protected User procurarUserNoBanco(String login) {
		User user = new User();
		user = userRepository.findOne(login);
		
		return user;
	}
	
	protected boolean validarParametros(User user, String senha, boolean permissao) {
		if (user.getSenha().equals(senha) && permissao) {
			return true;
		}
		return false;
	}
	
	protected void addUserInSession(HttpSession session, User user) {
		session.setAttribute("userLogado", user);
	}
		
	abstract boolean validarPermissao(HttpSession session,User user, String userType);

}
