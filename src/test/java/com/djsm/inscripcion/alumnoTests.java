package com.djsm.inscripcion;

import com.djsm.inscripcion.model.Alumno;
import com.djsm.inscripcion.repositories.AlumnoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
/**
 * Created by dsosa on 7/27/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class alumnoTests {

    @Autowired
    private AlumnoRepository alumnoRepository;


    @Test
    public void crearAlunmos(){

        Alumno al= new Alumno();

        al.setCedula("62493483");
        al.setNombre("Deibys");
        al.setApellido("Sosa");
        al.setDireccion("Av. Guasima");

        Alumno a= alumnoRepository.save(al);

        assertTrue(a.getCedula().equalsIgnoreCase(al.getCedula()));
    }


}
