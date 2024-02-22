package com.djsm.inscripcion.service;

import com.djsm.inscripcion.model.User;

import java.util.List;

/**
 * Created by dsosa on 7/25/2019.
 */

public interface UserService {

    User findById(long id);

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    Boolean isExistUser(User user);
}
