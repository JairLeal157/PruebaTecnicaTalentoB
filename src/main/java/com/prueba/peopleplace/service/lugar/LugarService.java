package com.prueba.peopleplace.service.lugar;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.LugarMapper;
import com.prueba.peopleplace.repository.LugarRepository;
import com.prueba.peopleplace.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LugarService implements ILugarService {

    private final LugarRepository lugarRepository;
    private final LugarMapper lugarMapper;
    private final PersonaRepository personaRepository;

    @Override
    public LugarDTO createLugar(LugarDTO lugarDTO) { // error por que el usuario no existe, o por que el lugar ya existe
        Lugar lugar = lugarMapper.toEntity(lugarDTO);
        Optional<Persona> persona = personaRepository.findById(lugarDTO.getPersonaId());
        lugar.setPersona(persona.orElse(null));
        lugar = lugarRepository.save(lugar);
        return lugarMapper.toDto(lugar);
    }

    @Override
    public List<LugarDTO> getLugaresByPais(String pais) {
        Optional<List<Lugar>> lugares = lugarRepository.findAllByPais(pais);
        return lugarMapper.toDto(lugares.orElse(null));
    }
}
