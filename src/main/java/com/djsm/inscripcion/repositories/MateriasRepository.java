package com.djsm.inscripcion.repositories;

import com.djsm.inscripcion.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriasRepository extends JpaRepository<Materia,Long>{
    Materia findByName(String name);
}
