package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.services.CourseGroupService;
import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.utilities.AssignGroupForm;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagementController {

    public final TraineeService traineeService;
    public final CourseGroupService courseGroupService;

    @Autowired
    public ManagementController(TraineeService traineeService, CourseGroupService courseGroupService) {
        this.traineeService = traineeService;
        this.courseGroupService = courseGroupService;
    }

    @GetMapping("/groups")
    public String getTrainerGroupView(Model model) {
        model.addAttribute("assignGroupForm", new AssignGroupForm());
        model.addAttribute("allTrainees", traineeService.getAllTrainees());
        model.addAttribute("allGroups", courseGroupService.getAllCourseGroups());
        return Pages.accessPage(Role.TRAINER, Pages.GROUPS);
    }

    @PostMapping("/submitGroupChange")
    public ModelAndView postGroupChange(@ModelAttribute AssignGroupForm assignGroupForm, ModelMap model) {

        if (assignGroupForm.getTraineeId() == 0 || assignGroupForm.getGroupId() == 0) {
            return new ModelAndView("redirect:"+Pages.accessPage(Role.TRAINER, "/groups"));
        }

        Trainee trainee = traineeService.changeTraineeCourseGroupByID(assignGroupForm.getTraineeId(), assignGroupForm.getGroupId());
        model.addAttribute("trainee", trainee);
        model.addAttribute("group", courseGroupService.getGroupByID(trainee.getGroupId()).get());
        return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.GROUPS_SUBMIT_CHANGE));
    }


}
