package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.WeekReport;
import com.sparta.eng68.traineetracker.services.WeekReportService;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestingController {
    WeekReportService weekReportService;

    @Autowired
    public TestingController(WeekReportService weekReportService) {
        this.weekReportService = weekReportService;
    }

    @GetMapping("/home")
    public String getHomePage() {
        return Pages.accessPage(Role.ANY, Pages.HOME_PAGE);
    }

    @GetMapping("/guide")
    public String getTraineeGuide() { return Pages.TRAINEE_GUIDE;}

    @GetMapping("/weeklyReports")
    public String getTraineeGuide(Model model) {
        List<WeekReport> reports = weekReportService.getAllReports();
        model.addAttribute("reports", reports);
        return Pages.TRAINEE_REPORT;
    }
}
