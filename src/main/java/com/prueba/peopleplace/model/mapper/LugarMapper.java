package com.prueba.peopleplace.model.mapper;

import com.prueba.peopleplace.model.dto.LugarDTO;
import com.prueba.peopleplace.model.entity.Lugar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LugarMapper extends EntityMapper<LugarDTO, Lugar> {

    @Mapping(target = "personaId", source = "persona.id_persona")
    LugarDTO toDto(Lugar entity);

}
