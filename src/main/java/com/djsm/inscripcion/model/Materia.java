package com.djsm.inscripcion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "tbl_materia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Materia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "name", nullable = false)
    private String name;

    private Especialidad especialidad;


}
