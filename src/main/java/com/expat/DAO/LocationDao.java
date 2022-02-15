package com.expat.DAO;

import com.techelevator.model.User;

import java.util.List;

public interface LocationDao {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean findIfUsernameIsTeacher(String username);

    boolean create();
}
