package com.prueba.peopleplace.repository;

import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LugarRepository extends JpaRepository<Lugar, Long> {
    @Query("SELECT l.persona from Lugar l where l.nombre = :nombre")
    Optional<List<Persona>> findAllPersonasByNombreLugar(String nombre);

    Optional<List<Lugar>> findAllByPais(String pais);

    boolean existsByNombreAndPaisAndPersona(String nombre, String pais, Persona persona);
}
