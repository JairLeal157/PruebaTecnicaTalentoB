package com.prueba.peopleplace.repository;

import com.prueba.peopleplace.model.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
}
