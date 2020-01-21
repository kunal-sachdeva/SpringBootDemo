package com.example.demo.service;

import com.example.demo.exception.ProductNotfoundException;
import com.example.demo.model.User;

public class ValidationService {
    public static void validateUser(User user){
        if(null!=user.getUsername() && null!=user.getPassword()
                && !user.getUsername().isEmpty() && !user.getPassword().isEmpty()){
            return;
        }
        throw new ProductNotfoundException("User/Password can not be null");
    }
}
