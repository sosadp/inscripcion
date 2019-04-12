package com.djsm.inscripcion.controller;


import com.djsm.inscripcion.model.Alumno;
import com.djsm.inscripcion.model.Especialidad;
import com.djsm.inscripcion.service.EspecialidadService;
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
public class EspApiController {

    public static Logger LOGGER= LoggerFactory.getLogger(EspApiController.class);


    @Autowired
    EspecialidadService especialidadService;

    @RequestMapping(value = "/esp/",method = RequestMethod.GET)
    public ResponseEntity<List<Especialidad>> lisAllEsp(){

        LOGGER.info("Ejecutando metodo TODAS las Especialidades");

        List<Especialidad> allEsp= especialidadService.findByAllEspe();

        if(allEsp.isEmpty()){

            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }

        LOGGER.info("las especialidades son: ",allEsp);
        return new ResponseEntity<List<Especialidad>>(allEsp,HttpStatus.OK);

    }


    @RequestMapping(value = "/esp/",method = RequestMethod.POST)
    public ResponseEntity<?> savedEsp(@RequestBody Especialidad especialidad, UriComponentsBuilder uriBuilder){
        LOGGER.info("Se creara la especialidad {}", especialidad.getId());

        if (especialidadService.isExistEspe(especialidad.getEspecilidad(),especialidad.getId())){

            LOGGER.info("La especialidad {}, no se puede crear",especialidad.getId());

            return new ResponseEntity(new CustomerErrorType("No se puede crear "+especialidad.getId()),HttpStatus.CONFLICT);
        }

        especialidadService.saveEspe(especialidad);

        HttpHeaders headers= new HttpHeaders();

        headers.setLocation(uriBuilder.path ("/api/espe/{id}").buildAndExpand(especialidad.getId()).toUri());

        return new ResponseEntity<String>(headers,HttpStatus.OK);


    }
}
