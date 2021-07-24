package com.epam.misp.framework.service;

import com.epam.misp.framework.model.User;

public class UserCreator {
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";


    public static User withCredentialsFromProperty() {
        User user = new User();
        user.setLogin(TestDataReader.getTestData(LOGIN));
        user.setPassword(TestDataReader.getTestData(PASSWORD));
        return user;
    }
}