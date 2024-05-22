package com.prueba.peopleplace.service.persona;

import com.prueba.peopleplace.model.dto.PersonaDTO;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.PersonaMapper;
import com.prueba.peopleplace.repository.LugarRepository;
import com.prueba.peopleplace.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private LugarRepository lugarRepository;

    @Mock
    private PersonaMapper personaMapper;

    @InjectMocks
    private PersonaService personaService;

    private PersonaDTO personaDTO;
    private Persona persona;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        personaDTO = new PersonaDTO();
        personaDTO.setNombre("John Doe");
        personaDTO.setEdad(30);
        personaDTO.setOcupacion("Engineer");

        persona = new Persona();
        persona.setNombre("John Doe");
        persona.setEdad(30);
        persona.setOcupacion("Engineer");
    }

    @Test
    void testCreatePersona_Success() {
        when(personaMapper.toEntity(personaDTO)).thenReturn(persona);
        when(personaRepository.save(persona)).thenReturn(persona);
        when(personaMapper.toDto(persona)).thenReturn(personaDTO);

        PersonaDTO createdPersona = personaService.createPersona(personaDTO);

        assertNotNull(createdPersona);
        assertEquals("John Doe", createdPersona.getNombre());
    }

    @Test
    void testGetPersonasByLugarNombre_Success() {
        when(lugarRepository.findAllPersonasByNombreLugar("Grand Canyon")).thenReturn(Optional.of(Arrays.asList(persona)));
        when(personaMapper.toDto(anyList())).thenReturn(Arrays.asList(personaDTO));

        List<PersonaDTO> personas = personaService.getPersonasByLugarNombre("Grand Canyon");

        assertNotNull(personas);
        assertEquals(1, personas.size());
        assertEquals("John Doe", personas.get(0).getNombre());
    }

    @Test
    void testGetPersonasByLugarNombre_Empty() {
        when(lugarRepository.findAllPersonasByNombreLugar("Grand Canyon")).thenReturn(Optional.empty());

        List<PersonaDTO> personas = personaService.getPersonasByLugarNombre("Grand Canyon");

        assertEquals(0, personas.size());
    }
}