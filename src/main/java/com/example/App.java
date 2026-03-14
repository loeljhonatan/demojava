package com.example;

import com.example.dao.UserDAO;
import com.example.model.User;

public class App {

    public static void main(String[] args) {

        User user = new User();

        user.setNombre("Maria");
        user.setApellido("Torre");
        user.setEdad(31);

        UserDAO userDao = new UserDAO();

        userDao.create(user);
        //System.out.println(user);

        /*

          for(User user1:userDao.findAll()){
            System.out.println(user1);
        };
        
        */

        /* 
        //Update
       User user1 = userDao.findById(2);
       System.out.println(user1);

       user1.setApellido("Montes");
       user1.setEdad(30);

       userDao.update(user1);

       System.out.println(user1);
        */
      
       /* 
        //delete 
        for(User user1:userDao.findAll()){
            System.out.println(user1);
        
        }

        User user2 = userDao.findById(2);
        userDao.delete(user2);

        System.out.println("luego de eliminar");

         for(User user1:userDao.findAll()){
            System.out.println(user1);
        
        }
            */

         for(User user1:userDao.findAll()){
            System.out.println(user1);}

    }
}
