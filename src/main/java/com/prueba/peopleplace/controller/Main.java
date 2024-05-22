package com.prueba.peopleplace.controller;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.dto.PersonaDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.LugarMapper;
import com.prueba.peopleplace.model.mapper.PersonaMapper;
import com.prueba.peopleplace.repository.PersonaRepository;
import com.prueba.peopleplace.service.lugar.LugarService;
import com.prueba.peopleplace.service.persona.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class Main {
    private final PersonaService personaService;
    private final LugarService lugarService;
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

    @GetMapping("/PersonasByLugarNombre/{nombre}")
    public List<PersonaDTO> getLugares(@PathVariable String nombre) {
        System.out.println("Nombre: " + nombre);
        return personaService.getPersonasByLugarNombre(nombre);
    }

    @GetMapping("/createPersona")
    public PersonaDTO createPersona() {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre("Juan");
        personaDTO.setEdad(20);
        personaDTO.setOcupacion("Estudiante");
        return personaService.createPersona(personaDTO);
    }

    @GetMapping("/getLuagresByPais/{pais}")
    public List<LugarDTO> getLugaresByPais(@PathVariable String pais) {
        return lugarService.getLugaresByPais(pais);
    }
}
