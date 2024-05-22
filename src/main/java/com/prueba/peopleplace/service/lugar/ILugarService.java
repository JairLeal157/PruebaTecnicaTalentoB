package com.prueba.peopleplace.service.lugar;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.entity.Lugar;

import java.util.List;

public interface ILugarService {
    public LugarDTO createLugar(LugarDTO lugarDTO);

    public List<LugarDTO> getLugaresByPais(String pais);
}
