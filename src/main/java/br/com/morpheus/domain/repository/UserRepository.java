package br.com.morpheus.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.morpheus.domain.model.User;

public interface UserRepository extends CrudRepository<User, String>{

}
