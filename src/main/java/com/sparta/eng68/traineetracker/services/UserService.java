package com.sparta.eng68.traineetracker.services;

import com.sparta.eng68.traineetracker.entities.User;
import com.sparta.eng68.traineetracker.repositories.UserRepository;
import com.sparta.eng68.traineetracker.utilities.CSVLoginWriter;
import com.sparta.eng68.traineetracker.utilities.PasswordGenerator;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
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
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public User getUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    public void addNewUser(String username) {
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUsername(username);
        String password = PasswordGenerator.generatePassword();
        user.setPassword(passwordEncoder.encode(password));
        PasswordGenerator.writeToFile(username,password);
        user.setRole(Role.FIRST_TIME_USER);

        userRepository.save(user);
    }

    public boolean isPasswordSame(String username, String password){
        User user = userRepository.findByUsername(username);
        String encodedPassword = user.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String encodedPasswordTest = passwordEncoder.encode(password);
        if(passwordEncoder.matches(password,encodedPassword)){
            return true;
        }else{
            return false;
        }
    }

    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}
