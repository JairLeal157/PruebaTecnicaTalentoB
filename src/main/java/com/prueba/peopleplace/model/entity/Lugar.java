package com.prueba.peopleplace.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lugar;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @Size(max = 100)
    private String departamento_o_estado;

    @NotBlank
    @Size(max = 100)
    private String pais;

    @ManyToOne
    @JoinColumn(name = "persona_id_persona", referencedColumnName = "id_persona")
    private Persona persona;
}
