package com.djsm.inscripcion.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tbl_materia")
public class Materia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "name", nullable = false)
    private String name;


    private Especialidad especialidad;






    public Materia() {

    }

    public Materia(String codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long mid) {
        this.id = mid;
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

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Materia materia = (Materia) o;

        if (id != null ? !id.equals(materia.id) : materia.id != null) return false;
        if (codigo != null ? !codigo.equals(materia.codigo) : materia.codigo != null) return false;
        if (name != null ? !name.equals(materia.name) : materia.name != null) return false;
        return especialidad != null ? especialidad.equals(materia.especialidad) : materia.especialidad == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", name='" + name + '\'' +
                ", especialidad=" + especialidad.getId()+
                '}';
    }
}
