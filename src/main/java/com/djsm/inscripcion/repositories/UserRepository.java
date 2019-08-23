package com.djsm.inscripcion.repositories;

import com.djsm.inscripcion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by dsosa on 7/25/2019.
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);
}


