package br.com.morpheus.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.morpheus.domain.model.User;
import br.com.morpheus.domain.repository.UserRepository;

@RestController
public class MobileController {
	
	private static final Logger log = LoggerFactory.getLogger(MobileController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showUser")
    public User showUser() {
		User user = userRepository.findOne("carlos");
		log.info(user.getNome());
        return user;
	}

}
