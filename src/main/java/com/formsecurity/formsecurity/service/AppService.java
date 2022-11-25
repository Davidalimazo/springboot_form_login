package com.formsecurity.formsecurity.service;

import com.formsecurity.formsecurity.db.UserRepository;
import com.formsecurity.formsecurity.entity.User;
import com.formsecurity.formsecurity.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(UserModel userModel){
    User user = userRepository.findByUsername(userModel.getUsername());
        User newUser = new User();
        if (user != null) {
            newUser.setUsername(userModel.getUsername());
            newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
            newUser.setActive(userModel.getActive());
            newUser.setRoles(userModel.getRoles());
            newUser.setPermissions(userModel.getPermissions());
            return userRepository.save(newUser);
        }else
            return null;
    }
    public List<User> getAllusers(){
        return userRepository.findAll();
    }

}