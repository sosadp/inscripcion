package com.djsm.inscripcion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="tbl_especialidad")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Especialidad implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="especialidad")
    private String especialidad;

    //private List<Materia> materias = new ArrayList<>();

    //@ManyToOne(fetch = FetchType.LAZY)
    private Alumno alumno;
}
