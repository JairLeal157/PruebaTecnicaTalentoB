package com.prueba.peopleplace.model.dto;

import com.prueba.peopleplace.model.entity.Persona;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LugarDTO {
    private Long id_lugar;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @Size(max = 100)
    private String departamento_o_estado;

    @NotBlank
    @Size(max = 100)
    private String pais;

    private Long personaId;

}
