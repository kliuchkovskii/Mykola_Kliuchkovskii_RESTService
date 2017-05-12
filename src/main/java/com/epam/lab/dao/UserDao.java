package com.epam.lab.dao;

import com.epam.lab.model.User;
import com.epam.lab.model.UserRole;
import com.epam.lab.utils.exceptions.UserServiceException;

import java.util.ArrayList;

public class UserDao {
    private ArrayList<User> users;

    public UserDao(){
        users = new ArrayList();
        initUsers();
    }

    private void initUsers(){
        users.add(new User());
        users.add(new User("Andrew","Grey","male",
                "greygrey9919@kolya.com","helloworld","0970000000", UserRole.ADMIN));
        users.add(new User("Anatoliy","Kryha","male",
                "anatoliy@kolya.com","helloworld","0974532226",UserRole.USER));
    }

    public boolean addUser(User user){
        try {
            users.add(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public User loginUser(String email, String password){
        for(User user : users){
            if(user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    return user;
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    public User getUser(String name, String surname){
        for(User user : users){
            if(user.getName().equals(name)&&user.getSurname().equals(surname)){
                return user;
            }
        }
        throw new UserServiceException(String.format("User \"%s %s\" does not exist.", name, surname));
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }

    public boolean removeUser(String name, String surname){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getName().equals(name)&&users.get(i).getSurname().equals(surname)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAllUsers(){
        return users.removeAll(users);
    }

    public ArrayList<User> getUsersByRole(UserRole role){
        ArrayList<User> usersByRole = new ArrayList();
        for(User user : users){
            if(user.getRole() == role){
                usersByRole.add(user);
            }
        }
        return usersByRole;
    }
}
