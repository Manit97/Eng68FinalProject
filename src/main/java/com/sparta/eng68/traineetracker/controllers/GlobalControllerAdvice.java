package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.entities.Trainer;
import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;

@ControllerAdvice(annotations = Controller.class)
public class GlobalControllerAdvice {

    private final TraineeService traineeService;
    private final TrainerService trainerService;

    @Autowired
    public GlobalControllerAdvice(TraineeService traineeService, TrainerService trainerService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
    }

    @ModelAttribute("username")
    public String getUsername(Principal principal, HttpServletRequest request) {
        if (principal == null) {
            return "";
        }

        Optional<Trainee> traineeOptional = traineeService.getTraineeByUsername(principal.getName());
        Optional<Trainer> trainerOptional = trainerService.getTrainerByUsername(principal.getName());

        if (trainerOptional.isPresent()) {
            Trainer trainer = trainerOptional.get();
            return trainer.getFirstName() + " " + trainer.getLastName();
        } else if (traineeOptional.isPresent()) {
            Trainee trainee = traineeOptional.get();
            return trainee.getFirstName() + " " + trainee.getLastName();
        }
        return "USER NOT FOUND";
    }
}
