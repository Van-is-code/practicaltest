package com.fptaptech.myapi.service;

import com.fptaptech.myapi.entity.User;
import com.fptaptech.myapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //DI
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
         Optional<User> user = userRepository.findById(id);
         return user.orElseThrow(() -> new RuntimeException("Ko tim thay" + id));
    }
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails){
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setSalary(userDetails.getSalary());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }
    public List<User> searchUser(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);

    }
    public void deleteUser(Long id){
        User user = getUserById(id);
        userRepository.delete(user);
    }


}
