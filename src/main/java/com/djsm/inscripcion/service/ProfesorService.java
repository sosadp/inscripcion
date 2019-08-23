package com.djsm.inscripcion.service;

import com.djsm.inscripcion.model.Profesor;

import java.util.List;

/**
 * Created by dsosa on 8/23/2019.
 */
public interface ProfesorService {

    Profesor findById(Long id);

    List<Profesor> findAll();

    void saved(Profesor profesor);

    void updateProfesor(Profesor profesor);

    void deleteById(Long id);

    Boolean isExistProfesor(Profesor profesor);


}
