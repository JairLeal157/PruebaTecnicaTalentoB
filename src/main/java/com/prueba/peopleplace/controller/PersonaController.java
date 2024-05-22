package com.prueba.peopleplace.controller;

import com.prueba.peopleplace.model.dto.PersonaDTO;
import com.prueba.peopleplace.service.persona.IPersonaService;
import com.prueba.peopleplace.service.persona.PersonaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@AllArgsConstructor
public class PersonaController {
    private final IPersonaService personaService;

    @PostMapping
    public PersonaDTO createPersona(@Valid @RequestBody PersonaDTO personaDTO) {
        return personaService.createPersona(personaDTO);
    }

    @GetMapping("/lugar/{nombre}")
    public List<PersonaDTO> getPersonasByLugarNombre(@PathVariable String nombre) {
        return personaService.getPersonasByLugarNombre(nombre);
    }
}
