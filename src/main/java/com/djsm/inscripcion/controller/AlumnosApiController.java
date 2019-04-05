package com.djsm.inscripcion.controller;

import com.djsm.inscripcion.model.Alumno;
import com.djsm.inscripcion.repositories.AlumnoRepository;
import com.djsm.inscripcion.service.AlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AlumnosApiController {

    public static Logger LOGGER = LoggerFactory.getLogger(AlumnosApiController.class);

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping(name = "/alumnos",method = RequestMethod.GET)
    public ResponseEntity<List<Alumno>> listAllAlumnos(){

        List<Alumno> alumnos =alumnoService.findByAlumnos();
            if(alumnos.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);

            }

        return new ResponseEntity<List<Alumno>>(alumnos,HttpStatus.OK);
    }
}
