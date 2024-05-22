package com.prueba.peopleplace.service.persona;

import com.prueba.peopleplace.model.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {

    public PersonaDTO createPersona(PersonaDTO personaDTO);

    public List<PersonaDTO> getPersonasByLugarNombre(String lugarNombre);
}
