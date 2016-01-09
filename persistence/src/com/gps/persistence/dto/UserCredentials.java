package com.gps.persistence.dto;

/**
 * Created by Marius on 09.01.2016.
 */
public class UserCredentials {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String email;
    String password;
}
