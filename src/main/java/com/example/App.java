package com.example;

import com.example.dao.UserDAO;
import com.example.model.User;

public class App {

    public static void main(String[] args) {

        UserDAO userDao = new UserDAO();


        //List
        for(User user1:userDao.findAll()){
            System.out.println(user1);
        }

    }
}
