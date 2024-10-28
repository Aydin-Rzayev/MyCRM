package com.MyCRM.MyCRM.services.Implements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyCRM.MyCRM.models.User;
import com.MyCRM.MyCRM.repositories.IUserRepository;
import com.MyCRM.MyCRM.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findUserByName(String name){
        Iterator<User> users = userRepository.findAll().iterator();
        Optional<User> userOptional = Optional.empty();
        while(users.hasNext()){
            User user = users.next();
            if(user.getName().equalsIgnoreCase(name)){
                userOptional = Optional.of(user);
            }
        }
        return userOptional.get();
    }

    public User findUserByEmail(String email){
        Iterator<User> users = userRepository.findAll().iterator();
        Optional<User> userOptional = Optional.empty();
        while(users.hasNext()){
            User user = users.next();
            if(user.getEmail().equals(email)){   
                userOptional = Optional.of(user); 
            }
        }
        return userOptional.get();
    }

    public List<Optional<User>> findUsersByRole(String role){
        Iterator<User> users = userRepository.findAll().iterator();
        List<Optional<User>> userOptional = new ArrayList<Optional<User>>();
        while(users.hasNext()){
            User user = users.next();
            if(user.getRole().equalsIgnoreCase(role)){
                userOptional.add(Optional.of(user));
            }
        }
        return userOptional;
    }

    public Optional<User> findUsersById(Integer Id){
        return userRepository.findById(Id);
    }

    public List<User> findAllUsers(){
        return (List<User>)userRepository.findAll();
    }

    public Boolean existsUser(User user){
        return userRepository.findAll().equals(user);
    }

    public Boolean deleteUser(User user){
        if(existsUser(user)){
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    
   
}
