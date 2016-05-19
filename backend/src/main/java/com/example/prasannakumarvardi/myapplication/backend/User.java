package com.example.prasannakumarvardi.myapplication.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prasannakumarvardi on 5/1/16.
 */

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class User{

    private String name;
    @Id private String email;
    private String password;
    private String phoneNumber;
    private String emergencyContactName;
    private String getEmergencyContactNumber;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){

    }


    public User(String name, String email, String phoneNumber){
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public User(String name, String email, String phoneNumber, String password,
                String emergencyContactName, String getEmergencyContactNumber){
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
        this.emergencyContactName = emergencyContactName;
        this.getEmergencyContactNumber = getEmergencyContactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getGetEmergencyContactNumber() {
        return getEmergencyContactNumber;
    }

    public void setGetEmergencyContactNumber(String getEmergencyContactNumber) {
        this.getEmergencyContactNumber = getEmergencyContactNumber;
    }
}
