package com.example.accountManagement.dao;

import com.example.accountManagement.model.User;

import java.util.List;

public interface UserDao {
    int addUser(String fullName);

    void deleteUserById(long id);

    List<User> getAllUsers();
}
