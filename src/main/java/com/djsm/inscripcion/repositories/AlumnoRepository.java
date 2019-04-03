package com.djsm.inscripcion.repositories;

import com.djsm.inscripcion.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long>{

    Alumno findByCedula(String cedula);

}
