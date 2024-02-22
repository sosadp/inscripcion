package com.djsm.inscripcion.model;

import jakarta.persistence.*;


/**
 * Created by dsosa on 8/1/2019.
 */
@Entity
@Table(name = "tbl_ins_detalles")
public class InscripDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Materia materia;

    private Alumno alumno;

    private Inscripcion inscripcion;


}
