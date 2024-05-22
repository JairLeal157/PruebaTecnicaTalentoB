package com.prueba.peopleplace.controller;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.service.lugar.ILugarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lugares")
@AllArgsConstructor
public class LugarController {
    private final ILugarService lugarService;

    @PostMapping
    public LugarDTO createLugar(@Valid @RequestBody LugarDTO lugarDTO) {
        System.out.println("LugarDTO: " + lugarDTO);
        return lugarService.createLugar(lugarDTO);
    }

    @GetMapping("/pais/{pais}")
    public List<LugarDTO> getLugaresByPais(String pais) {
        return lugarService.getLugaresByPais(pais);
    }
}
