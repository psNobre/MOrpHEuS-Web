package br.com.morpheus.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.morpheus.domain.model.Sensor;

public interface SensorRepository extends CrudRepository<Sensor, String>{

}
