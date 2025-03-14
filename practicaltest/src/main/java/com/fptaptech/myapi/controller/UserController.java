package com.fptaptech.myapi.controller;

import com.fptaptech.myapi.entity.User;
import com.fptaptech.myapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("v1/api/employees")
public class UserController {
    @Autowired//DI
    private UserService userService;

    @GetMapping//Get read
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping//POST create new user
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createUser = userService.createUser(user);
        return ResponseEntity.ok(createUser);
    }

    @PutMapping("/{id}")//PUT edit user
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User updateUser = userService.updateUser(id,userDetails);
        return ResponseEntity.ok(updateUser);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam String name) {
        List<User> user = userService.searchUser(name);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")//Delete delete user
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }




}
