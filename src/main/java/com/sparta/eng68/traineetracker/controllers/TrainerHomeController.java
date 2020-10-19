package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerHomeController {

    @GetMapping("/trainerHome")
    public String getTrainerHome() {
        return Pages.accessPage(Role.TRAINER, Pages.TRAINER_HOME);
    }

    @GetMapping("/newUser")
    public String newUserForm() {
        return Pages.accessPage(Role.TRAINER, Pages.TRAINER_NEW_USER_PAGE);
    }

}
