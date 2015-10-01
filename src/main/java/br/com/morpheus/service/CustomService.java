package br.com.morpheus.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.morpheus.config.StaticVariablesConfig;
import br.com.morpheus.domain.model.Medico;
import br.com.morpheus.domain.model.Paciente;
import br.com.morpheus.domain.model.Sensor;
import br.com.morpheus.domain.model.SensorValor;
import br.com.morpheus.domain.model.User;
import br.com.morpheus.domain.repository.MedicoRepository;
import br.com.morpheus.domain.repository.PacienteRepository;
import br.com.morpheus.domain.repository.SensorRepository;
import br.com.morpheus.domain.repository.SensorValorRepository;
import br.com.morpheus.domain.repository.UserRepository;
import br.com.morpheus.service.templates.LoginAsMedico;
import br.com.morpheus.service.templates.LoginAsPaciente;
import br.com.morpheus.service.templates.LoginUserTemplate;


@Service
public class CustomService {

	private static final Logger log = LoggerFactory.getLogger(CustomService.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private SensorRepository sensorRepository;
	@Autowired
	private SensorValorRepository sensorValorRepository;


	/**
	 * Serviços Gerência de Usuarios Metodos: addUserAsPaciente 
	 * 										  addUserAsMedico
	 **/
	public void addUserAsPaciente(User user, Paciente paciente) {
		log.info("Usuário Adicionado no Banco.");
		userRepository.save(user);
		paciente.setUser(user);
		log.info("Usuário Adicionado como Paciente");
		pacienteRepository.save(paciente);
	}

	public void addUserAsMedico(User user, Medico medico) {
		log.info("Usuário Adicionado no Banco.");
		userRepository.save(user);
		medico.setUser(user);
		log.info("Usuário Adicionado como Médico.");
		medicoRepository.save(medico);
	}

	/**
	 * Serviços Login Metodos: loginUser
	 **/
	public String loginUser(HttpSession session, String login, String senha, String userType){
		boolean userAtorizado = false;
		
		if (userType.equals(StaticVariablesConfig.TYPE_MEDICO)) {
			log.info("Usuário é Médico.");
			LoginUserTemplate lTemplate = new LoginAsMedico();
			userAtorizado = lTemplate.executeLoginTemplete(session, login, senha, userType);
			if (userAtorizado) {
				log.info("Usuário Autorizado.");
				return "menu-medico";
			} 
		} 
		else if (userType.equals(StaticVariablesConfig.TYPE_PACIENTE)) {
			log.info("Usuário é Paciente.");
			LoginUserTemplate lTemplate = new LoginAsPaciente();
			userAtorizado = lTemplate.executeLoginTemplete(session, login, senha, userType);
			if (userAtorizado) {
				log.info("Usuário Autorizado.");
				return "menu-paciente";
			} 
		}			
		return "formlogin";
	}
	
	public User loginUserMobile(String login, String senha){
		User user = new User();
		user.setLogin("-1");
		if (loginUserMobileValidation(login, senha)) {
			return userRepository.findOne(login);
		}
		return user;
	}
	
	public boolean loginUserMobileValidation(String login, String senha){
		boolean permissao = false;
		if (userRepository.exists(login) && userRepository.findOne(login).getSenha().equals(senha)) {
			permissao = true;
		}else{
			permissao = false;
		}
		return permissao;
	}

	/**
	 * Serviços Médicos Metodos: 
	 **/
	
	public void addPacienteParaMedico(Medico medico, String login, Paciente paciente){
		Iterable<Medico> medicos = medicoRepository.findAll();
		for (Medico med : medicos) {
			if (med.getUser().getLogin().equals(login)) {
				List<Paciente> pacientes= med.getPacientes();
				pacientes.add(paciente);
				medicoRepository.save(med);
			}
		}
	}
	
	/**
	 * Serviços para Pacientes Metodos: 
	 **/
	public void addSensoresParaPaciente(Paciente paciente, Iterable<Sensor> sensores){
		//TODO
	}
	
	/**
	 * Serviços para Sensores/SensorValor Metodos: 
	 **/
	
	public void addPacienteParaSensor(Sensor sensor, Iterable<Paciente> pacientes){
		//TODO
	}
	
	public void addValorParaSensor(Paciente paciente, Sensor sensor, SensorValor valor){
		//TODO
	}
	
}
