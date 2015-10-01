package br.com.morpheus.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.morpheus.domain.model.Medico;

public interface MedicoRepository extends CrudRepository<Medico, String> {
}
