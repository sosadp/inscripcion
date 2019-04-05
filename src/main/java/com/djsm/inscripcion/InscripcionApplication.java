package com.djsm.inscripcion;

import com.djsm.inscripcion.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages ={"com.djsm.inscripcion"} )
public class InscripcionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InscripcionApplication.class, args);
	}

}
