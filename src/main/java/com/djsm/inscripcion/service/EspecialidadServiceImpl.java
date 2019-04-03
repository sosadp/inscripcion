package com.djsm.inscripcion.service;

import com.djsm.inscripcion.model.Especialidad;
import com.djsm.inscripcion.repositories.EspecialidadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EspecialidadService")
@Transactional
public class EspecialidadServiceImpl implements EspecialidadService{


    public static Logger LOGGER = LoggerFactory.getLogger(EspecialidadServiceImpl.class);

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad findById(Long id) {
        return especialidadRepository.getOne(id);
    }

    @Override
    public List<Especialidad> findByAllEspe() {
        return especialidadRepository.findAll();
    }

    @Override
    public void saveEspe(Especialidad especialidad) {
            especialidadRepository.save(especialidad);
    }

    @Override
    public void updateEspe(Especialidad especialidad) {
        saveEspe(especialidad);
    }

    @Override
    public void deleteById(Long id) {
        especialidadRepository.deleteById(id);
    }

    @Override
    public Boolean isExistEspe(Especialidad especialidad) {
        return especialidadRepository.findByEspecilidad(especialidad.getEspecilidad())!=null;
    }
}
