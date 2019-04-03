package com.djsm.inscripcion.service;


import com.djsm.inscripcion.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AlumnoService {

    Alumno findById(Long id);

    List<Alumno> findByAlumnos();

    void saveAlumno(Alumno alumno);

    void updateAlumno (Alumno alumno);

    void deleteById (Long id);

    Boolean isExistAlumno(Alumno alumno);



}
