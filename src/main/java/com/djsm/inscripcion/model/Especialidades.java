package com.djsm.inscripcion.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Especialidad")
public class Especialidades implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="especialidad")
    private String especilidad;


    public Especialidades() {
    }

    public Especialidades(String especilidad) {
        this.especilidad = especilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecilidad() {
        return especilidad;
    }

    public void setEspecilidad(String especilidad) {
        this.especilidad = especilidad;
    }
}
