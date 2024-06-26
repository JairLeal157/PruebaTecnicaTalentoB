package com.prueba.peopleplace.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;

    @NotBlank()
    @Size(max = 100)
    private String nombre;

    @NotNull
    @Min(value = 0)
    private Integer edad;

    @Size(max = 100)
    private String ocupacion;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Lugar> lugares;
}