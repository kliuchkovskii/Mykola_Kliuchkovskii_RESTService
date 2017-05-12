package com.epam.lab.service;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.MediaType;


public interface UserService {

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    Response getUsers();

    @GET
    @Path("/usersByRole")
    @Produces(MediaType.APPLICATION_JSON)
    Response getUserByRole(@QueryParam("role") String role);

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    Response getUser(@QueryParam("name") String name,
                              @QueryParam("surname") String surname);

    @POST
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response registerUser(@FormParam("name") String name,
                          @FormParam("surname") String surname,
                          @FormParam("gender") String gender,
                          @FormParam("email") String email,
                          @FormParam("password") String password,
                          @FormParam("phone") String phone,
                          @FormParam("role") String role
    );

    @DELETE
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    Response removeUser(@QueryParam("name") String name, @QueryParam("surname") String surname);

    @DELETE
    @Path("/removeAll")
    @Produces(MediaType.APPLICATION_JSON)
    Response removeAllUsers();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response loginUser(   @FormParam("email") String email,
                          @FormParam("password") String password
    );
}
