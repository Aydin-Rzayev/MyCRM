package com.MyCRM.MyCRM.services.Implements;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyCRM.MyCRM.models.User;
import com.MyCRM.MyCRM.repositories.IUserRepository;
import com.MyCRM.MyCRM.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers(){
        return (List<User>)userRepository.findAll();
    }

    @Override
    public Boolean existsUser(User user){
        return userRepository.findAll().contains(user);
    }

    @Override
    public Boolean deleteUser(User user){
        if(existsUser(user)){
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    
   
}
