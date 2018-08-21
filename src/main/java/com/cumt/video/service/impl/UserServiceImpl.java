package com.cumt.video.service.impl;

import com.cumt.video.dataobject.User;
import com.cumt.video.repository.UserRepository;
import com.cumt.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean queryuserNameIsExist(String username) {
        User user = userRepository.findByuserName(username);
        if (user == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByuserName(username);
    }

    @Override
    public User queryUserByUserId(Integer userId) {
        return userRepository.findById(userId).get();
    }
}
