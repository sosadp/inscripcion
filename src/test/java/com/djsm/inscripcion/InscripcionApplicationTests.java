package com.djsm.inscripcion;

import com.djsm.inscripcion.model.User;
import com.djsm.inscripcion.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by dsosa on 7/25/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InscripcionApplicationTests {

    @Autowired
    private UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    public void crearUsuarioTest(){
        User user= new User();

        user.setName("dsosa");
        user.setPass(encoder.encode("test1") );

        User userRet= repository.save(user);


        assertTrue(userRet.getPass().equalsIgnoreCase(user.getPass()));
    }
}

