package com.prueba.peopleplace.service.lugar;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.model.mapper.LugarMapper;
import com.prueba.peopleplace.repository.LugarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LugarService implements ILugarService {

    private final LugarRepository lugarRepository;
    private final LugarMapper lugarMapper;

    @Override
    public LugarDTO createLugar(LugarDTO lugarDTO) {
        Lugar lugar = lugarMapper.toEntity(lugarDTO);
        lugar = lugarRepository.save(lugar);
        return lugarMapper.toDto(lugar);
    }

    @Override
    public List<LugarDTO> getLugaresByPais(String pais) {
        Optional<List<Lugar>> lugares = lugarRepository.findAllByPais(pais);
        return lugarMapper.toDto(lugares.orElse(null));
    }
}
