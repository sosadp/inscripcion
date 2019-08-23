package com.djsm.inscripcion.repositories;

import com.djsm.inscripcion.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dsosa on 8/23/2019.
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
}
