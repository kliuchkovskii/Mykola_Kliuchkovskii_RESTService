package com.epam.lab.service;


import com.epam.lab.model.User;
import com.epam.lab.utils.ResponseHandler;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/UserService")
public class UserServiceImpl implements UserService{

    @Override
    public Response getUsers() {
        return ResponseHandler.getAllUsers();
    }

    @Override
    public Response getUserByRole(String role) {
        return ResponseHandler.getUserByRole(role);
    }

    @Override
    public Response getUser(String name, String surname) {
        return ResponseHandler.getUser(name, surname);
    }

    @Override
    public Response registerUser(String name, String surname, String gender, String email, String password, String phone, String role) {
        return ResponseHandler.addUser(name,surname,gender,email,password,phone,role);
    }

    @Override
    public Response removeUser(String name, String surname) {
        return ResponseHandler.removeUser(name, surname);
    }

    @Override
    public Response removeAllUsers() {
        return ResponseHandler.removeAllUsers();
    }

    @Override
    public Response loginUser(String email, String password) {
        return ResponseHandler.loginUser(email, password);
    }
}
