package com.example.helloworld.model;

public class userDetails {
    private String userId, usernameSignUp, emailSignup, Password, NIM;

    public userDetails() {
    }

    public userDetails(String userId, String username, String userEmail, String userPassword, String userNIM) {
        this.userId = userId;
        this.usernameSignUp = username;
        this.emailSignup = userEmail;
        this.Password = userPassword;
        this.NIM = userNIM;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return usernameSignUp;
    }

    public void setUserName(String userName) {
        this.usernameSignUp = userName;
    }

    public String getUserEmail() {
        return emailSignup;
    }

    public void setUserEmail(String userEmail) {
        this.emailSignup = userEmail;
    }

    public String getUserPassword() {
        return Password;
    }

    public void setUserPassword(String userPassword) {
        this.Password = userPassword;
    }

    public String getUserNIM() {
        return NIM;
    }

    public void setUserNIM(String userNIM) {
        this.NIM = userNIM;
    }
}