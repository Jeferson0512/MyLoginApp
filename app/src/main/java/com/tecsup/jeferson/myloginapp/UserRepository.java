package com.tecsup.jeferson.myloginapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 9/10/2017.
 */

public class UserRepository {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(100,"jbujaico", "tecsup", "Jeferson Bujaico"));
        users.add(new User(200,"bbujaico", "tecsup", "Benjamin Bujaico"));
    }

    public static User login(String username, String password){
        for (User user: users){
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }


    public static User Useradd (String username, String password, String fullname){

        for(int i=400;i>=9999;i+=100){
            users.add(new User(i,username, password,fullname));
        }
        return login(username,password);

    }

    public static User getUser(String username){
        for (User user :users){
            if (user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }
}
