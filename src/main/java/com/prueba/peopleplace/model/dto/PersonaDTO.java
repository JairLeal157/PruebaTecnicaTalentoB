package com.prueba.peopleplace.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {

    private Long id_persona;

    @NotBlank()
    @Size(max = 100)
    private String nombre;

    @NotNull
    @Min(value = 0)
    private Integer edad;

    @Size(max = 100)
    private String ocupacion;
}