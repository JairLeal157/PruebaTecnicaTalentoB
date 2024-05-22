package com.prueba.peopleplace.controller;

import com.prueba.peopleplace.model.dto.PersonaDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.LugarMapper;
import com.prueba.peopleplace.model.mapper.PersonaMapper;
import com.prueba.peopleplace.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class Main {
    private PersonaMapper personaMapper;
    private PersonaRepository personaRepository;
    private LugarMapper lugarMapper;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/users")
    public PersonaDTO getUsers() {
        Persona persona = personaRepository.findById(4L).orElse(null);
        assert persona != null;
        List<Lugar> lugares = persona.getLugares();
        System.out.println(lugarMapper.toDto(lugares));
        return personaMapper.toDto(persona);
    }
}
