package br.com.morpheus.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="SENSOR")
public class Sensor {
	
	@Id
	@Column(name="CIB_ID")
	private String cib;
	
	@Column(name="NOME_COL")
	private String nome;
	
	//Rela��o com M�dicos
	@ManyToMany(mappedBy = "sensores", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Paciente> pacientes;
	
	//Rela��o com Sensor Valores
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="sensor") 
	@JsonIgnore
	private List<SensorValor> sensorValors;

	//Getters and Setters
	public String getCib() {
		return cib;
	}

	public void setCib(String cib) {
		this.cib = cib;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<SensorValor> getSensorValors() {
		return sensorValors;
	}

	public void setSensorValors(List<SensorValor> sensorValors) {
		this.sensorValors = sensorValors;
	}
	
	

	
	
}
