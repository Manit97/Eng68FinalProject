package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.services.CourseGroupService;
import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.utilities.NewUserForm;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerHomeController {

    public final CourseGroupService courseGroupService;
    public final TraineeService traineeService;

    @Autowired
    public TrainerHomeController(CourseGroupService courseGroupService, TraineeService traineeService) {
        this.courseGroupService = courseGroupService;
        this.traineeService = traineeService;
    }

    @GetMapping("/trainerHome")
    public String getTrainerHome() {
        return Pages.accessPage(Role.TRAINER, Pages.TRAINER_HOME);
    }

    @GetMapping("/newUser")
    public String newUserForm(Model model) {
        model.addAttribute("newUserForm", new NewUserForm());
        model.addAttribute("allGroups", courseGroupService.getAllCourseGroups());
        model.addAttribute("allTrainees", traineeService.getAllTrainees());
        return Pages.accessPage(Role.TRAINER, Pages.TRAINER_NEW_USER_PAGE);
    }

}
