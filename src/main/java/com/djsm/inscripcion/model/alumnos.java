package com.djsm.inscripcion.model;


import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="Alumnos")
public class alumnos implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="cedula",nullable = false)
    private String cedula;

    @Column(name = "nombre")
    private String nombre;


    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;


}
