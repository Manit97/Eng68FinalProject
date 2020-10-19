package com.sparta.eng68.traineetracker.services;

import com.sparta.eng68.traineetracker.entities.User;
import com.sparta.eng68.traineetracker.repositories.UserRepository;
import com.sparta.eng68.traineetracker.utilities.PasswordGenerator;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addFirstPassword(String username, String newPassword) {
        User user = userRepository.findByUsername(username);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);

        user.setPassword(encodedPassword);
        user.setRole(Role.TRAINEE);

        userRepository.save(user);
    }

    public void changePasswordByUsername(String username, String newPassword) {
        User user = userRepository.findByUsername(username);

        user.setPassword(newPassword);

        userRepository.save(user);
    }

    public void addNewUser(String username) {
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(PasswordGenerator.generatePassword()));
        user.setRole(Role.FIRST_TIME_USER);

        userRepository.save(user);
    }

}
