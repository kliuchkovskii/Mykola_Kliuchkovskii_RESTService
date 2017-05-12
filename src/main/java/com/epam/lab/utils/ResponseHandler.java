package com.epam.lab.utils;

import com.epam.lab.dao.UserDao;
import com.epam.lab.model.User;

import com.epam.lab.model.UserRole;
import com.epam.lab.utils.exceptions.UserServiceException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class ResponseHandler {
	
	private static Gson GSON =  new GsonBuilder().setPrettyPrinting().create();
	private static UserDao DAO = new UserDao();

	private static String EMAIL_PASSWORD_INCORRECT = "Email or password are incorrect";
	private static String INCORRECT_INPUT_VALUE = "Incorrect input value: ";
	private static String USER_NOT_FOUND = "User was not found";
	private static String NO_INPUT_PARAMETERS = "There are not input parameters: ";
	private static String NO_USERS_BY_ROLE = "There are no users with such role: ";
	
	private static String USER_WAS_ADDED = "User was added successfully";
	private static String USER_WAS_DELETED = "User was deleted successfully";
	private static String ALL_USERS_WERE_DELETED = "All users were deleted successfully";
	
	
	public static Response getAllUsers(){
		return Response.status(200).entity(GSON.toJson(DAO.getAllUsers())).build();
	}

	public static Response getUser(String name, String surname) {
		User result = DAO.getUser(name, surname);

		if(result == null){
			throw new UserServiceException(USER_NOT_FOUND, Status.NO_CONTENT);
		}
		return Response.status(200).entity(GSON.toJson(result)).build();
	}

	public static Response getUserByRole(String role) {
		ArrayList<User> result;
		if(role == null){
			throw new UserServiceException(NO_INPUT_PARAMETERS+"[role:"+role+"]",
					Status.BAD_REQUEST);
		}else{
			result = DAO.getUsersByRole(UserRole.getRole(role));
		}
		if(result.size()<1){
			throw new UserServiceException(NO_USERS_BY_ROLE
					+"[role:"+role+"]",Status.NO_CONTENT);
		}
		return Response.status(200).entity(GSON.toJson(result)).build();
	}


	public static Response addUser(String name, String surname, String gender, String email,
								   String password, String telephoneNumber, String userRole) {

		if(name == null || surname == null || gender == null || email == null || password == null || telephoneNumber == null || userRole == null){
			throw new UserServiceException(INCORRECT_INPUT_VALUE
					+"[name:"+name+",surname:"+surname+",gender:"+gender+",email:"+email+",password:"+password+"," +
					"telephoneNumber:"+telephoneNumber+",userRole:"+userRole+"]", Status.BAD_REQUEST);
		}

		User user = new User(name, surname, gender, email, password, telephoneNumber, UserRole.getRole(userRole));

		JsonObject result = new JsonObject();

		DAO.addUser(user);
		result.addProperty("Message",USER_WAS_ADDED);

		return Response.status(200).entity(result.toString()).build();
	}


	public static Response removeUser(String name, String surname) {
		if(name == null || surname == null){
			throw new UserServiceException(INCORRECT_INPUT_VALUE+"[name:"+name+",surname:"+surname+"]",Status.BAD_REQUEST);
		}

		JsonObject result = new JsonObject();

		boolean removingResult = DAO.removeUser(name, surname);
		if(removingResult) {
			result.addProperty("message", USER_WAS_DELETED);
		}

		return Response.status(200).entity(result.toString()).build();
	}

	public static Response removeAllUsers(){
		JsonObject result = new JsonObject();

		boolean removingResult = DAO.removeAllUsers();
		if(removingResult) {
			result.addProperty("message", ALL_USERS_WERE_DELETED);
		}
		return Response.status(200).entity(result.toString()).build();
	}
	
	public static Response loginUser(String email, String password){
		User result = DAO.loginUser(email, password);

		if(result == null){
			throw new UserServiceException(EMAIL_PASSWORD_INCORRECT, Status.UNAUTHORIZED);
		}
		return Response.status(200).entity(GSON.toJson(result)).build();
	}
	
}
