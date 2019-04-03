package com.djsm.inscripcion.service;

import com.djsm.inscripcion.model.Materia;

import java.util.List;

public interface MateriaService {

    Materia findById(Long id);

    List<Materia> findAllMaterias();

    void saveMaterias(Materia materia);

    void updateMaterias(Materia materia);

    void deleteById(Long id);

    Boolean isExistMateria(Materia materia);
}
