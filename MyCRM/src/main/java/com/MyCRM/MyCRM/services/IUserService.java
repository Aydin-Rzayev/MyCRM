package com.MyCRM.MyCRM.services;


import java.util.List;

import com.MyCRM.MyCRM.models.User;

public interface IUserService {
    public User saveUser(User user);

    public List<User> findAllUsers();

    public Boolean existsUser(User user);

    public Boolean deleteUser(User user);
}
