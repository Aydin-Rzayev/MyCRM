package com.MyCRM.MyCRM.controllers.Implements;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.MyCRM.MyCRM.controllers.IUserController;
import com.MyCRM.MyCRM.models.User;
import com.MyCRM.MyCRM.services.Implements.UserServiceImpl;

@RestController
@RequestMapping(path = "/user")
public class UserControllerImpl implements IUserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/all")
    @Override
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping(path = "/add")
    @Override
    public ResponseEntity<User> addUser(@RequestBody User user){
        if(userService.existsUser(user)){
           return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
        }
        else{
            return ResponseEntity.ok(userService.saveUser(user));
        }
    }

    @DeleteMapping(path = "/delete")
    @Override
    public ResponseEntity<Boolean> deleteUser(@RequestBody User user){
        if(!userService.existsUser(user)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         else{
             return ResponseEntity.ok(userService.deleteUser(user));
         }
    }



    
    



}
