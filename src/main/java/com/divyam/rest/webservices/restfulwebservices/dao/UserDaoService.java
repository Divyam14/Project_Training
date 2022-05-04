package com.divyam.rest.webservices.restfulwebservices.dao;


import com.divyam.rest.webservices.restfulwebservices.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    //Initial implement as static arraylist but with change to take from JPA later
    private final static List<User> users = new ArrayList<>();
    private static int usersCount = 5;


    static {
        users.add(new User(1,"David",new Date()));
        users.add(new User(2,"Blake",new Date()));
        users.add(new User(3,"Atyhi",new Date()));
        users.add(new User(4,"kaye",new Date()));
        users.add(new User(5,"Ray",new Date()));
    }

    public List<User> findAll(){
        return users;
    }


    public User saveUser(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }


    public User findOne(int id){
        for (User user:users) {
            if (user.getId() == id){
                return user;
            }

        }
        return null;
    }

    public User deleteById(Integer id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId().equals(id)){
                iterator.remove();
                return user;
            }
        }
        return null;
    }


}
