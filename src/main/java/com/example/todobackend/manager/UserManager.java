package com.example.todobackend.manager;

import com.example.todobackend.database.entity.User;
import com.example.todobackend.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    public User getUserFromSecurityContext(){
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String username = authentication.getName();
        Optional<User> userOpt = userRepository.findByUsername(username);
        User user = null;
        if(userOpt.isPresent())
        {
            return userOpt.get();
        }
        return user;
    }
}