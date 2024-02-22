package com.djsm.inscripcion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by dsosa on 7/23/2019.
 */
@Entity
@Table(name = "tbl_inscripcion")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inscripcion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ins_date")
    private Date ins_date;

    private Especialidad especialidad;
}
