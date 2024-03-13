package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //static ArrayList를 만들어 통신하기

    private static int usersCount = 0;
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "EVe", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "jes", LocalDate.now().minusYears(10)));

    }
    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}

