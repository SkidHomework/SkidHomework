package org.cubewhy.skidhomework.service.impl;

import jakarta.annotation.Resource;
import org.cubewhy.skidhomework.entity.User;
import org.cubewhy.skidhomework.repository.UserRepository;
import org.cubewhy.skidhomework.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User findByUsernameOrEmail(String value) {
        return userRepository.findByUsername(value).orElseGet(() -> userRepository.findByEmail(value).orElse(null));
    }

    @Override
    public User register(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
}
