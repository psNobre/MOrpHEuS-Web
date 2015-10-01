package br.com.morpheus.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.morpheus.domain.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, String> {

}
