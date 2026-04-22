package com.gtwndtl.crudapp.repository;

import com.gtwndtl.crudapp.entity.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    void delete(Integer id);
    User getById(Integer id);
    List<User> getAll();
    void update(User user);
}
