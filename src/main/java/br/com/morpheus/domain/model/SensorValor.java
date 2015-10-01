package br.com.morpheus.domain.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="SENSOR_VALOR")
public class SensorValor {
	
	@Id @GeneratedValue
	@Column(name="SENSOR_VALOR_ID")
	private int id;
	
	@Column(name="VALOR_COL")
	private String valor;
	
	@Column(name="DATA_COL")
	private Timestamp data;
	
	//Relação com Sensor
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="SENSOR_CIB_ID") 
	@JsonIgnore
	private Sensor sensor;
	
	//Relação com Paciente
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="PACIENTE_PACIENTE_ID") 
	@JsonIgnore
	private Paciente paciente;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@Override
	public String toString() {
		return "SensorValor [id=" + id + ", valor=" + valor + ", data=" + data + "]";
	}
	
	
	
}
