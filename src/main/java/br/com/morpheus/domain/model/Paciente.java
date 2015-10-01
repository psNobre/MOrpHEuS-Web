package br.com.morpheus.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="PACIENTE")
public class Paciente {
	
	@Id @GeneratedValue
	@Column(name="PACIENTE_ID")
	private int id;
	
	@Column(name="DIAGNOSTICO_COL")
	private String diagnostico;
	
	//Rela��o com Usuario
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="USER_LOGIN_ID") 
	@JsonIgnore
	private User user;
	
	//Rela��o com M�dicos
	@ManyToMany(mappedBy = "pacientes", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Medico> medicos;
	
	//Rela��o com Sensor
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PACIENTE_HAS_SENSOR", joinColumns = @JoinColumn(name = "PACIENTE_ID", referencedColumnName = "PACIENTE_ID", insertable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "CIB_ID", referencedColumnName = "CIB_ID", insertable = false, updatable = false))
	@JsonIgnore
	private List<Sensor> sensores;
	
	//Rela��o com Sensor Valores
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="paciente")
	@JsonIgnore
	private List<SensorValor> sensorValors;
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Sensor> getSensors() {
		return sensores;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensores = sensors;
	}
	

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	public List<SensorValor> getSensorValors() {
		return sensorValors;
	}

	public void setSensorValors(List<SensorValor> sensorValors) {
		this.sensorValors = sensorValors;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", diagnostico=" + diagnostico + ", user=" + user + "]";
	}

	
}
