package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraineeHomeController {

    @GetMapping("/traineeHome")
    public String getTraineeHome() {
        return Pages.accessPage(Roles.TRAINEE, Pages.TRAINEE_HOME);
    }

}
