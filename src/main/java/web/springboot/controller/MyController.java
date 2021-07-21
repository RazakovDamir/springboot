package web.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.springboot.entity.User;
import web.springboot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.getUser(id);
        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getUser(id);
        userService.deleteUser(id);
        return "User with ID = " + id + " was deleted";
    }

}
