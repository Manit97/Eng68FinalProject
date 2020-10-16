package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraineeHomeController {

    @GetMapping("/traineeHome")
    public String getTraineeHome() {
        return Pages.accessPage(Role.TRAINEE, Pages.TRAINEE_HOME);
    }

}
