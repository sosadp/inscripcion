package com.djsm.inscripcion.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;



@Entity
@Table(name="tbl_alumno")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alumno implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;


    @Column(name="cedula",nullable = false)
    private String cedula;

    @Column(name = "nombre")
    private String nombre;


    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    //@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    //private List<Especialidad> espeID= new ArrayList<>();

}
