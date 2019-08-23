package com.djsm.inscripcion.repositories;

import com.djsm.inscripcion.model.Especialidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Long>{

    Especialidad findByEspecialidadAndId(String especialidad,Long id);

}
