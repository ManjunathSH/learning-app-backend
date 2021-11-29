package com.virtualschool.learning.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

//    @Id
//    @GeneratedValue
//    @Column(name = "USER_ID")
//    private Integer userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_TYPE")
    private String type;

    @Id
    @Column(name = "USER_ID")
    private String phoneNumber;

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
//                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
