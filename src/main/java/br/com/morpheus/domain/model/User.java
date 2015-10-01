package br.com.morpheus.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity(name="USUARIO")
public class User {
	
	@Id
	@Column(name="LOGIN_ID")
	private String login;
	
	@Column(name="SENHA_COL")
	private String senha;
	
	@Column(name="NOME_COL")
	private String nome;
	
	@Column(name="EMAIL_COL")
	private String email;
	
	//Rela��o com M�dico
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	private List<Medico> medicos;
	
	//Rela��o com Paciente
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user") 
	@JsonIgnore
	private List<Paciente> pacientes;
	
	//Getters and Setters
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", senha=" + senha + ", nome=" + nome + ", email=" + email +"]";
	}


	
	

}
