package com.djsm.inscripcion.service;

import com.djsm.inscripcion.model.Materia;
import com.djsm.inscripcion.repositories.MateriasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MateriaServiceImpl implements MateriaService{
    public static Logger LOGGER= LoggerFactory.getLogger(MateriaServiceImpl.class);

    @Autowired
    private MateriasRepository  materiasRepository;

    @Override
    public Materia findById(Long id) {
        return materiasRepository.getOne(id);
    }

    @Override
    public List<Materia> findAllMaterias() {
        return materiasRepository.findAll();
    }

    @Override
    public void saveMaterias(Materia materia) {
        materiasRepository.save(materia);
    }

    @Override
    public void updateMaterias(Materia materia) {
        saveMaterias(materia);
    }

    @Override
    public void deleteById(Long id) {
        materiasRepository.deleteById(id);
    }

    @Override
    public Boolean isExistMateria(Materia materia) {
        return materiasRepository.findByName(materia.getName())!=null;
    }
}
