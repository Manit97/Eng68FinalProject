package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.entities.WeekReport;
import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.services.WeekReportService;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TraineeReportController {
    WeekReportService weekReportService;
    TraineeService traineeService;

    @Autowired
    public TraineeReportController(WeekReportService weekReportService, TraineeService traineeService) {
        this.weekReportService = weekReportService;
        this.traineeService = traineeService;
    }

    @GetMapping("/guide")
    public String getTraineeGuide() {
        return Pages.accessPage(Role.TRAINEE, Pages.TRAINEE_GUIDE);
    }

    @GetMapping("/weeklyReports")
    public String getTraineeWeeklyReports(@RequestParam Integer id, Model model) {
        Trainee trainee = traineeService.getTraineeByID(id).get();
        List<WeekReport> reports = weekReportService.getReportsByTraineeID(id);
        model.addAttribute("trainee", trainee);
        model.addAttribute("reports", reports);
        model.addAttribute("now", LocalDateTime.now());
        return Pages.accessPage(Role.TRAINEE, Pages.TRAINEE_REPORT);
    }
}
