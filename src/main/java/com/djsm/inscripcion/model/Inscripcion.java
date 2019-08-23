package com.djsm.inscripcion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by dsosa on 7/23/2019.
 */
@Entity
@Table(name = "tbl_inscripcion")
public class Inscripcion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ins_date")
    private Date ins_date;


    private Especialidad especialidad;


    public Inscripcion() {
    }

    public Long getInsid() {
        return id;
    }

    public void setInsid(Long insid) {
        this.id = insid;
    }


}
