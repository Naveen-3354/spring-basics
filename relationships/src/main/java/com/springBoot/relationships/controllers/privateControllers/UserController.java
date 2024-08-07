package com.springBoot.relationships.controllers.privateControllers;

import com.springBoot.relationships.models.entity.User;
import com.springBoot.relationships.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService service;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable long id){
        return service.selectById(id);
    }

    @PostMapping("/bulk")
    public String createManyUsers(@RequestBody List<User> users){
        return service.insertManyUsers(users);
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        return service.insertUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }

}
