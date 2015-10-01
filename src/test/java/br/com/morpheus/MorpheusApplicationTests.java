package br.com.morpheus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.morpheus.config.StaticVariablesConfig;
import br.com.morpheus.domain.model.Sensor;
import br.com.morpheus.domain.repository.SensorRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MorpheusApplication.class)
public class MorpheusApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(MorpheusApplicationTests.class);
	
	@Autowired
	private SensorRepository sensorRepository;
	
	@Test
	public void addSensors() {
		Sensor sensor1 = new Sensor();
		sensor1.setCib(StaticVariablesConfig.CIB_BODY_POSITION);
		sensor1.setNome("Posicao Corporal");
		
		Sensor sensor2 = new Sensor();
		sensor2.setCib(StaticVariablesConfig.CIB_BODY_TEMPERATURE);
		sensor2.setNome("Temperatura Corporal");
		
		Sensor sensor3 = new Sensor();
		sensor3.setCib(StaticVariablesConfig.CIB_AIRFLOW);
		sensor3.setNome("Fluxo de Respiracao");
		
		Sensor sensor4 = new Sensor();
		sensor4.setCib(StaticVariablesConfig.CIB_ELECTROCARDIOGRAM);
		sensor4.setNome("Eletrocardiograma");
		
		Sensor sensor5 = new Sensor();
		sensor5.setCib(StaticVariablesConfig.CIB_MYOCARDIOGRAM);
		sensor5.setNome("Miocardiograma");
		
		Sensor sensor6 = new Sensor();
		sensor6.setCib(StaticVariablesConfig.CIB_GLUCOMETER);
		sensor6.setNome("Glicosimetro");
		
		Sensor sensor7 = new Sensor();
		sensor7.setCib(StaticVariablesConfig.CIB_GALVANIK_SKIN_RESPONSE);
		sensor7.setNome("Resistencia da Pele");
		
		Sensor sensor8 = new Sensor();
		sensor8.setCib(StaticVariablesConfig.CIB_OXIMETER);
		sensor8.setNome("Oximetro");
		
		Sensor sensor9 = new Sensor();
		sensor9.setCib(StaticVariablesConfig.CIB_PRESSURE_BLOOD);
		sensor9.setNome("Pressao Arterial");
		
		Sensor sensor10 = new Sensor();
		sensor10.setCib(StaticVariablesConfig.CIB_PULSE);
		sensor10.setNome("Pulso");
		
		sensorRepository.save(sensor1);
		sensorRepository.save(sensor2);
		sensorRepository.save(sensor3);
		sensorRepository.save(sensor4);
		sensorRepository.save(sensor5);
		sensorRepository.save(sensor6);
		sensorRepository.save(sensor7);
		sensorRepository.save(sensor8);
		sensorRepository.save(sensor9);
		sensorRepository.save(sensor10);
		
		log.info("Adicionando todos os sensores que o sistema suporta.");
	}

}
