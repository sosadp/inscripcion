package com.djsm.inscripcion.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materia")
public class Materia implements Serializable{

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "name", nullable = false)
    private String name;

    public Materia() {
    }

    public Materia(String codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
