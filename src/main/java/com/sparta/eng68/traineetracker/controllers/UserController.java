package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.repositories.UserRepository;
import com.sparta.eng68.traineetracker.services.UserService;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/passwordInitialiser")
    public ModelAndView getPasswordInitialiser(ModelMap modelMap) {

        return new ModelAndView(Pages.accessPage(Role.FIRST_TIME_USER, Pages.FIRST_PASSWORD_PAGE), modelMap);
    }

    @PostMapping("/addFirstPassword")
    public ModelAndView changePasswordForUser(@RequestParam String password, ModelMap modelMap, Principal principal) {
        String username = principal.getName();



        userService.addFirstPassword(username, password);

        return new ModelAndView("redirect:"+Pages.accessPage(Role.ANY, Pages.LOGOUT_CURRENT_USER), modelMap);
    }

    @PostMapping("/addNewUser")
    public ModelAndView addNewUser(@RequestParam String username, ModelMap modelMap) {
        userService.addNewUser(username);

        return new ModelAndView("redirect:"+Pages.accessPage(Role.TRAINER, Pages.TRAINER_HOME_REDIRECT), modelMap);
    }

}
