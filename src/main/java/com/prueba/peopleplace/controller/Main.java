package com.prueba.peopleplace.controller;

import com.prueba.peopleplace.model.dto.PersonaDTO;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.PersonaMapper;
import com.prueba.peopleplace.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class Main {
    private PersonaMapper personaMapper;
    private PersonaRepository personaRepository;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/users")
    public PersonaDTO getUsers() {
        Persona persona = personaRepository.findById(1L).orElse(null);
        System.out.println(persona);
        return personaMapper.toDto(persona);
    }
}
