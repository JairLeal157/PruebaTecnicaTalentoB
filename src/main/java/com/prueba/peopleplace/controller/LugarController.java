package com.prueba.peopleplace.controller;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.service.lugar.ILugarService;
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
@Tag(name = "API Lugares", description = "API for managing Lugares")
@RequestMapping("/lugares")
@AllArgsConstructor
public class LugarController {
    private final ILugarService lugarService;

    @PostMapping
    @Operation(summary = "Create a new place",
            description = "Create a new Lugar",
            responses = {
                @ApiResponse(responseCode = "201", description = "Lugar created"),
                @ApiResponse(responseCode = "404", description = "Person not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                @ApiResponse(responseCode = "409", description = "Lugar already exists for this person", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<LugarDTO> createLugar(@Valid @RequestBody LugarDTO lugarDTO) {
        System.out.println("LugarDTO: " + lugarDTO);
        return ResponseEntity.status(201).body(lugarService.createLugar(lugarDTO));
    }

    @GetMapping("/pais/{pais}")
    @Operation(summary = "Get places by country",
            description = "Get a list of places by country",
            responses = {
                @ApiResponse(responseCode = "200", description = "List of places by country"),
                @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<List<LugarDTO>> getLugaresByPais(@PathVariable String pais) {
        return  ResponseEntity.status(201).body(lugarService.getLugaresByPais(pais));
    }
}
