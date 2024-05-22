package com.prueba.peopleplace.controller;

import com.prueba.peopleplace.model.dto.PersonaDTO;
import com.prueba.peopleplace.service.persona.IPersonaService;
import com.prueba.peopleplace.util.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name = "API Personas", description = "API for managing Personas")
@RequestMapping("/personas")
@AllArgsConstructor
public class PersonaController {
    private final IPersonaService personaService;

    @PostMapping
    @Operation(summary = "Create a new person",
            description = "Create a new Persona",
            responses = {
                @ApiResponse(responseCode = "201", description = "Persona created"),
                @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<PersonaDTO> createPersona(@Valid @RequestBody PersonaDTO personaDTO) {
        return ResponseEntity.status(201).body(personaService.createPersona(personaDTO));
    }


    @GetMapping("/lugar/{nombre}")
    @Operation(summary = "search Personas who visited a Lugar",
            description = "Get a list of people who visited a place by name",
            responses = {
                @ApiResponse(responseCode = "200", description = "List of Personas"),
                @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<List<PersonaDTO>> getPersonasByLugarNombre(@PathVariable String nombre) {
        return ResponseEntity.status(201).body(personaService.getPersonasByLugarNombre(nombre));
    }
}
