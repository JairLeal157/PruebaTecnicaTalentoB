package com.prueba.peopleplace.service.lugar;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.entity.Persona;
import com.prueba.peopleplace.model.mapper.LugarMapper;
import com.prueba.peopleplace.repository.LugarRepository;
import com.prueba.peopleplace.repository.PersonaRepository;
import com.prueba.peopleplace.util.error.exception.ConflictException;
import com.prueba.peopleplace.util.error.exception.PersonNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
public class LugarService implements ILugarService {

    private final LugarRepository lugarRepository;
    private final LugarMapper lugarMapper;
    private final PersonaRepository personaRepository;

    @Override
    public LugarDTO createLugar(LugarDTO lugarDTO) {
        Lugar lugar = lugarMapper.toEntity(lugarDTO);
        Optional<Persona> persona = personaRepository.findById(lugarDTO.getPersonaId());
        if(persona.isEmpty()) {
            throw new PersonNotFoundException("Persona with id " + lugarDTO.getPersonaId() + " does not exist");
        }
        if (lugarRepository.existsByNombreAndPaisAndPersona(lugar.getNombre(), lugar.getPais(), persona.get())) {
            throw new ConflictException("Lugar already exists for this persona");
        }
        lugar.setPersona(persona.get());
        lugar = lugarRepository.save(lugar);
        return lugarMapper.toDto(lugar);
    }

    @Override
    public List<LugarDTO> getLugaresByPais(String pais) {
        Optional<List<Lugar>> lugaresOptional = lugarRepository.findAllByPais(pais);
        List<Lugar> lugares = lugaresOptional.orElse(null);
        lugares = this.uniqueLugares(lugares);
        return lugarMapper.toDto(lugares);
    }

    private List<Lugar> uniqueLugares(List<Lugar> lugares){
        if(lugares == null) return null;
        Map<String, Lugar> map = new HashMap<>();
        for (Lugar lugar : lugares) {
            map.put(lugar.getNombre()+lugar.getDepartamento_o_estado() , lugar);
        }
        return new ArrayList<>(map.values());

    }
}
