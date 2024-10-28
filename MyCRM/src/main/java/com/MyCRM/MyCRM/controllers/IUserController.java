package com.MyCRM.MyCRM.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.MyCRM.MyCRM.models.User;

public interface IUserController {
    public ResponseEntity<User> addUser(User user);

    public ResponseEntity<List<User>> getAllUsers();

    public ResponseEntity<Boolean> deleteUser(User user);
}
