package br.com.morpheus.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="MEDICO")
public class Medico {
	
	@Id @GeneratedValue
	@Column(name="MEDICO_ID")
	private int id;
	
	@Column(name="ESPECIALIDADE_COL")
	private String especialidade;
	
	//Rela��o com Usuario
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="USER_LOGIN_ID") 
	@JsonIgnore
	private User user;
	
	//Rela��o com Paciente
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MEDICO_HAS_PACIENTE", joinColumns = @JoinColumn(name = "MEDICO_ID", referencedColumnName = "MEDICO_ID", insertable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "PACIENTE_ID", referencedColumnName = "PACIENTE_ID", insertable = false, updatable = false))
	@JsonIgnore
	private List<Paciente> pacientes;

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", especialidade=" + especialidade + ", user=" + user + "]";
	}
	
	


}
