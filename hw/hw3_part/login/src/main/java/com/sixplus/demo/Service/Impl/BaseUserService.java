package com.sixplus.demo.Service.Impl;

import com.sixplus.demo.Entity.User;
import com.sixplus.demo.Repository.UserRepository;
import com.sixplus.demo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Slf4j
public class BaseUserService implements UserService {
    private final UserRepository userRepository;

    public BaseUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void insert(User user){
        String username = user.getUsername();
        if(exist(username)){
            throw new RuntimeException("用户名已存在!");
        }
        userRepository.save(user);
    }

    @Override
    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    private boolean exist(String username){
        User user = userRepository.findByUsername(username);
        return (user!=null);
    }
}
