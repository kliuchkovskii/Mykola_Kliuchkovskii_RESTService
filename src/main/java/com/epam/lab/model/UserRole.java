package com.epam.lab.model;


public enum UserRole {
    USER("user"),
    ADMIN("admin");

    private String userRole;

    UserRole(String role){
        this.userRole = role;
    }

    public static UserRole getRole(String role){
        role = role.toLowerCase();
        UserRole[] roles = UserRole.values();
        for(UserRole userRole : roles){
            if(role.equals(userRole.getUserRole())){
                return userRole;
            }
        }
        return null;
    }

    public String getUserRole(){
        return userRole;
    }
}
