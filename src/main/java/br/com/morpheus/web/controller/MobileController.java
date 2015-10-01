package br.com.morpheus.web.controller;


import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.morpheus.domain.model.User;
import br.com.morpheus.service.CustomService;

@RestController
public class MobileController {
	
	private static final Logger log = LoggerFactory.getLogger(MobileController.class);
	
	@Autowired
	private CustomService customService;
	
	@RequestMapping(value="/loginUserMobile")
    public User addUser(@RequestBody HashMap<String, String> authUser) {
		String login = authUser.get("login");
		String senha = authUser.get("senha");
		log.info("Autenticação de Usuário");
        return customService.loginUserMobile(login, senha);
	}

}
