package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    String deleteById(int id);

    User update(int id, User user);

    List<User> getAll();

    User findById(int id);

}
