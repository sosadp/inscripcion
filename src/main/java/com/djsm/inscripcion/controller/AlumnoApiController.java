package com.djsm.inscripcion.controller;

import com.djsm.inscripcion.model.Alumno;

import com.djsm.inscripcion.service.AlumnoService;
import com.djsm.inscripcion.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AlumnoApiController {

    public static Logger LOGGER = LoggerFactory.getLogger(AlumnoApiController.class);

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping(value = "/alumno/",method = RequestMethod.GET)
    public ResponseEntity<List<Alumno>> listAllAlumnos(){
        LOGGER.info("Tratando de Obtener listado");
        List<Alumno> alumnos =alumnoService.findByAlumnos();
            if(alumnos.isEmpty()){
                LOGGER.error("No hay informacion para mostrar");
                return new ResponseEntity(new CustomErrorType("No informacion para mostrar"),HttpStatus.NO_CONTENT);
            }
        return new ResponseEntity<List<Alumno>>(alumnos,HttpStatus.OK);
    }

    @RequestMapping(value = "/alumno/",method =RequestMethod.POST)
    public ResponseEntity<?> createAlumnos(@RequestBody Alumno alumno, UriComponentsBuilder ucBuilder){
        LOGGER.info("Se va a crear un alumno",alumno.getCedula());
        if (alumnoService.isExistAlumno(alumno)){
            LOGGER.error("Este alumno ya existe {}",alumno.getCedula()) ;

            return new ResponseEntity(new CustomErrorType("No se puede registrar el alumno "+alumno.getCedula()),HttpStatus.CONFLICT);
        }

        alumnoService.saveAlumno(alumno);

        HttpHeaders headers=new HttpHeaders();

        headers.setLocation(ucBuilder.path("/alumno/{id}").buildAndExpand(alumno.getCedula()).toUri());

        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/alumno/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getAlumno(@PathVariable("id") long id){
        LOGGER.info("Se buscara el usuario con Id{}",id);
        Alumno current = alumnoService.findById(id);

        if (current==null){
            LOGGER.error("El usuario {}, no se encuentra ",id);
            return new ResponseEntity(new CustomErrorType("No se encontro el usuario "+id),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Alumno>(current, HttpStatus.OK);
    }

    @RequestMapping(value = "/alumno/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateAlumno(@PathVariable("id") long id,@RequestBody Alumno alumno){
        LOGGER.info("Actualizacion de Alumno {} ",id + " en proceso");
        Alumno current=alumnoService.findById(id);

        if (!alumnoService.isExistAlumno(current)){
            LOGGER.error("Alumno no encontrado para actualizar");
            return new ResponseEntity(new CustomErrorType("No hay Alumno para actualizar"),HttpStatus.NOT_FOUND);
        }

        current.setApellido(alumno.getApellido());
        current.setCedula(alumno.getCedula());
        current.setDireccion(alumno.getDireccion());
        current.setNombre(alumno.getNombre());
        alumnoService.updateAlumno(current);

        return new ResponseEntity<Alumno>(current,HttpStatus.OK);

    }

    @RequestMapping(value = "/alumno/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAlum(@PathVariable("id") Long id){
        Optional<Alumno> current = Optional.ofNullable(alumnoService.findById(id));

        if (current.isPresent() && !alumnoService.isExistAlumno(current.get())){


            return new ResponseEntity(new CustomErrorType("No hay registro para borrar"),HttpStatus.NOT_FOUND);
       // if (!alumnoService.isExistAlumno(current)){

        //    return new ResponseEntity(new CustomErrorType("No hay registro para borrar"),HttpStatus.NOT_FOUND);
        }

        alumnoService.deleteById(id);

        return  new ResponseEntity(new CustomErrorType("Registro eliminado con exito"),HttpStatus.OK);

    }
}
