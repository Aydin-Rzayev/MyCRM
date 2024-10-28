package com.MyCRM.MyCRM.controllers.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.MyCRM.MyCRM.controllers.IUserController;
import com.MyCRM.MyCRM.services.Implements.ClientServiceImpl;

@RestController

public class UserControllerImpl implements IUserController {
    @Autowired
    private ClientServiceImpl clientService;

    



}
