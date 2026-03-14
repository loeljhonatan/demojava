package com.example.dao;

import java.util.List;

import com.example.model.User;

public interface IUserDAO {

    public void create(User user);
    public void update(User user);
    public void delete(User user);

    public List<User> findAll();
    public User findById(Integer id);

}
