package com.prueba.peopleplace.service.lugar;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.LugarMapper;
import com.prueba.peopleplace.repository.LugarRepository;
import com.prueba.peopleplace.repository.PersonaRepository;
import com.prueba.peopleplace.util.error.exception.ConflictException;
import com.prueba.peopleplace.util.error.exception.PersonNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class LugarServiceTest {
    @Mock
    private LugarRepository lugarRepository;

    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private LugarMapper lugarMapper;

    @InjectMocks
    private LugarService lugarService;

    private List<Lugar> lugares;

    private List<LugarDTO> lugaresDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        lugares = new ArrayList<>();
        lugares.add(new Lugar(1L, "Grand Canyon", "Arizona", "USA", new Persona()));
        lugares.add(new Lugar(2L, "Statue of Liberty", "new york", "USA", new Persona()));

        lugaresDTO = new ArrayList<>();
        lugaresDTO.add(new LugarDTO(1L, "Grand Canyon", "Arizona", "USA", 1L));
        lugaresDTO.add(new LugarDTO(2L, "Statue of Liberty", "new york", "USA", 1L));
    }

    @Test
    void testGetLugaresByPais_Success() {
        when(lugarRepository.findAllByPais("USA")).thenReturn(Optional.of(lugares));
        when(lugarMapper.toDto(lugares)).thenReturn(lugaresDTO);

        List<LugarDTO> uniqueLugares = lugarService.getLugaresByPais("USA");

        assertNotNull(uniqueLugares);
        assertEquals(lugaresDTO, uniqueLugares);
    }

    @Test
    void testGetLugaresByPais_Empty() {
        when(lugarRepository.findAllByPais("USA")).thenReturn(Optional.empty());

        List<LugarDTO> lugares = lugarService.getLugaresByPais("USA");

        assertEquals(lugares, new ArrayList<>());
    }

    @Test
    void testCreateLugar_Success() {
        when(personaRepository.findById(1L)).thenReturn(Optional.of(new Persona()));
        when(lugarRepository.existsByNombreAndPaisAndPersona(anyString(), anyString(), any(Persona.class))).thenReturn(false);
        when(lugarMapper.toEntity(lugaresDTO.get(0))).thenReturn(lugares.get(0));
        when(lugarRepository.save(any(Lugar.class))).thenReturn(lugares.get(0));
        when(lugarMapper.toDto(any(Lugar.class))).thenReturn(lugaresDTO.get(0));

        LugarDTO createdLugar = lugarService.createLugar(lugaresDTO.get(0));

        assertNotNull(createdLugar);
        assertEquals("Grand Canyon", createdLugar.getNombre());
    }

    @Test
    void testCreateLugar_PersonNotFound() {
        when(personaRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(PersonNotFoundException.class, () -> {
            lugarService.createLugar(lugaresDTO.get(0));
        });

        String expectedMessage = "Persona with id 1 does not exist";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateLugar_Conflict() {
        Long personaId = 1L;
        when(personaRepository.findById(personaId)).thenReturn(Optional.of(new Persona(1L,"Juan",32, "ingenerio", lugares)));
        when(lugarMapper.toEntity(lugaresDTO.get(0))).thenReturn(lugares.get(0));
        when(lugarRepository.existsByNombreAndPaisAndPersona(anyString(), anyString(), any(Persona.class))).thenReturn(true);

        Exception exception = assertThrows(ConflictException.class, () -> {
            lugarService.createLugar(lugaresDTO.get(0));
        });

        String expectedMessage = "Lugar already exists for this persona";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}