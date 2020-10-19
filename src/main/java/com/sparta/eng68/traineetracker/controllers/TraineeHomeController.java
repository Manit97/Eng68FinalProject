package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.WeekReport;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class TraineeHomeController {

    @GetMapping("/traineeHome")
    public String getTraineeHome() {
        return Pages.accessPage(Role.TRAINEE, Pages.TRAINEE_HOME);
    }

    @GetMapping("/traineeFeedback")
    public String getTraineeFeedbackForm(Model model) {
        model.addAttribute("traineeFeedback", new WeekReport());
        return Pages.accessPage(Role.TRAINEE, Pages.TRAINEE_FEEDBACK);
    }

    @PostMapping("/traineeUpdateReport")
    public void submitTraineeFeedbackForm(@ModelAttribute WeekReport weekReport){
        weekReport.setTraineeConsultantGradeFlag((byte) 1);
        weekReport.setTraineeTechnicalGradeFlag((byte) 1);
        weekReport.setTraineeStartFlag((byte) 1);
        weekReport.setTraineeStopFlag((byte) 1);
        weekReport.setTraineeContinueFlag((byte) 1);
        weekReport.setMostRecentEdit(LocalDateTime.now());
    }

}
