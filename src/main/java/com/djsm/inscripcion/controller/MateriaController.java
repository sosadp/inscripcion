package com.djsm.inscripcion.controller;

import com.djsm.inscripcion.model.Materia;
import com.djsm.inscripcion.repositories.MateriasRepository;
import com.djsm.inscripcion.service.MateriaService;
import com.djsm.inscripcion.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by dsosa on 5/7/2019.
 */

@RestController
@RequestMapping("/api")
public class MateriaController {

    public static Logger LOGGER = LoggerFactory.getLogger(MateriaController.class);

    @Autowired
    MateriaService materiaService;


    public ResponseEntity<?> savedMater(@RequestBody Materia materia, UriComponentsBuilder builder){

        LOGGER.info("Guardando la materia {}",materia.getName());

        if (materiaService.isExistMateria(materia)){

            return new ResponseEntity(new CustomErrorType("No se puede salvar "+materia.getId()), HttpStatus.NO_CONTENT);
        }

        materiaService.saveMaterias(materia);

        HttpHeaders headers= new HttpHeaders();

        headers.setLocation(builder.path("api/materia/{id}").buildAndExpand(materia.getId()).toUri());

        return new ResponseEntity<String>(headers,HttpStatus.OK);
    }
}
