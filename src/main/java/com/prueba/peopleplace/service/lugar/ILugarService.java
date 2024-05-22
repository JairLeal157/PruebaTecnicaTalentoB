package com.prueba.peopleplace.service.lugar;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import com.prueba.peopleplace.util.error.exception.ConflictException;
import com.prueba.peopleplace.util.error.exception.PersonNotFoundException;

import java.util.List;

public interface ILugarService {
    public LugarDTO createLugar(LugarDTO lugarDTO) throws PersonNotFoundException, ConflictException;

    public List<LugarDTO> getLugaresByPais(String pais);
}
