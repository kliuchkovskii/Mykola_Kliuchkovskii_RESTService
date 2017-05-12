package com.epam.lab.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
    private String name;
    private String surname;
    private String gender;
    private String email;
    private String password;
    private String telephoneNumber;
    private UserRole role;

    public User(String name, String surname, String gender, String email,
                String password, String telephoneNumber, UserRole role) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
    }

    public User(){
        name = "John";
        surname = "Li";
        gender = "male";
        email = "John.li1986@kolya.com";
        password = "helloworld";
        telephoneNumber = "0777777777";
        role = UserRole.USER;
    }

    @Override
    public String toString(){
        return String.format("First name - %s\n" +
                "Second Name - %s\n" +
                "Email - %s\n" +
                "Telephone number - %s\n" +
                "User Role - %s",name, surname, email, telephoneNumber, role);
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    @XmlElement
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @XmlElement
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    @XmlElement
    public void setRole(UserRole role) {
        this.role = role;
    }
}
