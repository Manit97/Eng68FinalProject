package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.utilities.AssignGroupForm;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManagementController {

    public final TraineeService traineeService;

    @Autowired
    public ManagementController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/groups")
    public String getTrainerGroupView(Model model) {
        model.addAttribute("assignGroupForm", new AssignGroupForm());
        model.addAttribute("allTrainees", traineeService.getAllTrainees());
        return Pages.accessPage(Role.TRAINER, Pages.GROUPS);
    }

    @PostMapping("/submitGroupChange")
    public String postGroupChange(@ModelAttribute AssignGroupForm assignGroupForm, Model model) {
        model.addAttribute("id", assignGroupForm.getTraineeId());
        return Pages.accessPage(Role.TRAINER, Pages.GROUPS_SUBMIT_CHANGE);
    }


}
