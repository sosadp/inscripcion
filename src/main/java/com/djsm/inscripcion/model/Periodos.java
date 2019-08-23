package com.djsm.inscripcion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dsosa on 7/23/2019.
 */
@Entity
@Table(name = "tbl_periodos")
public class Periodos implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;


    public Periodos() {
    }



    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Periodos{" +
                "pid=" + pid +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Periodos periodos = (Periodos) o;

        if (pid != null ? !pid.equals(periodos.pid) : periodos.pid != null) return false;
        if (codigo != null ? !codigo.equals(periodos.codigo) : periodos.codigo != null) return false;
        return nombre != null ? nombre.equals(periodos.nombre) : periodos.nombre == null;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
