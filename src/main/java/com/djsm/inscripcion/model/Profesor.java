package com.djsm.inscripcion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dsosa on 8/1/2019.
 */
@Entity
@Table(name = "tbl_profesor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

}
