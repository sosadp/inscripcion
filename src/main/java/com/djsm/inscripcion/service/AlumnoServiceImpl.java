package com.djsm.inscripcion.service;


import com.djsm.inscripcion.model.Alumno;
import com.djsm.inscripcion.repositories.AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AlumnoService")
@Transactional
public class AlumnoServiceImpl implements AlumnoService{

    public static Logger LOGGER = LoggerFactory.getLogger(AlumnoServiceImpl.class);


    @Autowired
    private AlumnoRepository alumnoRepository;


    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.getOne(id);
    }

    @Override
    public List<Alumno> findByAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public void updateAlumno(Alumno alumno) {
        saveAlumno(alumno);
    }

    @Override
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Boolean isExistAlumno(Alumno alumno) {
        return alumnoRepository.findByCedula(alumno.getCedula())!=null;
    }
}
