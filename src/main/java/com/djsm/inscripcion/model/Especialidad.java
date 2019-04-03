package com.djsm.inscripcion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Especialidad")
public class Especialidad implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="especialidad")
    private String especilidad;


    @ManyToMany
    @JoinTable(name = "mat_curso",joinColumns = @JoinColumn(name = "especialidad_id"),inverseJoinColumns = @JoinColumn(name = "materias_id"))
    private Set<Materia> materias;

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public Especialidad() {
    }

    public Especialidad(String especilidad) {
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

    public Especialidad(Set<Materia> materias) {
        this.materias = materias;
    }
}
