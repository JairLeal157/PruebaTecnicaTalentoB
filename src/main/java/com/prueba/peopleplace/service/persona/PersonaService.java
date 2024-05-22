package com.prueba.peopleplace.service.persona;

import com.prueba.peopleplace.model.dto.PersonaDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.PersonaMapper;
import com.prueba.peopleplace.repository.LugarRepository;
import com.prueba.peopleplace.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springdoc.core.converters.ResponseSupportConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaService implements IPersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final LugarRepository lugarRepository;

    @Override
    public PersonaDTO createPersona(PersonaDTO personaDTO) { // Error, persona ya está en la base de datos

        Optional<Persona> personaOptional = personaRepository.findById(personaDTO.getId_persona());
        if(personaOptional.isPresent()){


        }
        Persona persona = personaMapper.toEntity(personaDTO);
        persona = personaRepository.save(persona);
        return personaMapper.toDto(persona);
    }

    @Override
    public List<PersonaDTO> getPersonasByLugarNombre(String lugarNombre) {
        List<Persona> personas = lugarRepository.findAllPersonasByNombreLugar(lugarNombre).orElse(null);
        return personaMapper.toDto(personas);
    }
}
