package com.djsm.inscripcion.service;

import com.djsm.inscripcion.model.Especialidad;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EspecialidadService {

    Especialidad findById(Long id);

    List<Especialidad> findByAllEspe();

    void saveEspe(Especialidad especialidad);

    void updateEspe(Especialidad especialidad);

    void deleteById(Long id);

    Boolean isExistEspe(String especialidad, Long id);

}
