package org.example;

import org.example.model.User;
import org.example.service.UserService;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        UserService userService = new UserService();

        userService.save(new User(
                "meder",
                "tynychbekov",
                "meder@gmail.com",
                "biskek",
                (byte) 23));

        List<User> users = userService.findAll();

        User user = userService.findById(1L);

        System.out.println(user);
//        users.forEach(System.out::println);

    }
}
