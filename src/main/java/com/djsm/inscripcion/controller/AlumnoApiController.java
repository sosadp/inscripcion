package com.djsm.inscripcion.controller;

import com.djsm.inscripcion.model.Alumno;

import com.djsm.inscripcion.service.AlumnoService;
import com.djsm.inscripcion.util.CustomerErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AlumnoApiController {

    public static Logger LOGGER = LoggerFactory.getLogger(AlumnoApiController.class);

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping(value = "/alumno/",method = RequestMethod.GET)
    public ResponseEntity<List<Alumno>> listAllAlumnos(){

        List<Alumno> alumnos =alumnoService.findByAlumnos();
            if(alumnos.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);

            }

        return new ResponseEntity<List<Alumno>>(alumnos,HttpStatus.OK);
    }

    @RequestMapping(name = "/alumno",method =RequestMethod.POST)
    public ResponseEntity<?> createAlumnos(@RequestBody Alumno alumno, UriComponentsBuilder ucBuilder){
        LOGGER.info("Se va a crear un alumno",alumno.getCedula());



        if (alumnoService.isExistAlumno(alumno)){
            LOGGER.error("Este alumno ya existe {}",alumno.getCedula()) ;

            return new ResponseEntity(new CustomerErrorType("No se puede registrar el alumno "+alumno.getCedula()),HttpStatus.CONFLICT);
        }

        alumnoService.saveAlumno(alumno);

        HttpHeaders headers=new HttpHeaders();

        headers.setLocation(ucBuilder.path("/api/alumno/{id}").buildAndExpand(alumno.getCedula()).toUri());

        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }
}
