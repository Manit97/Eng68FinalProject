package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.WeekReport;
import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.services.WeekReportService;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class TraineeHomeController {

    private final WeekReportService weekReportService;
    private final TraineeService traineeService;

    @Autowired
    public TraineeHomeController(WeekReportService weekReportService, TraineeService traineeService) {
        this.weekReportService = weekReportService;
        this.traineeService = traineeService;
    }

    @GetMapping("/traineeHome")
    public String getTraineeHome() {
        return Pages.accessPage(Role.TRAINEE, Pages.TRAINEE_HOME);
    }

    @GetMapping("/traineeFeedback")
    public String getTraineeFeedbackForm(Model model, Principal principal) {
        Integer traineeId = traineeService.getTraineeByUsername(principal.getName()).get().getTraineeId();
        model.addAttribute("traineeFeedback", weekReportService.getCurrentWeekReportByTraineeID(traineeId).get());
        return Pages.accessPage(Role.TRAINEE, Pages.TRAINEE_FEEDBACK_FORM_PAGE);
    }

    @PostMapping("/traineeUpdateReport")
    public String submitTraineeFeedbackForm(Integer reportId, String stopTrainee, String startTrainee,
                                            String continueTrainee, String traineeConsulGrade,
                                            String traineeTechGrade){

        WeekReport weekReport = weekReportService.getWeekReportByReportId(reportId).get();
        weekReport.setStopTrainee(stopTrainee);
        weekReport.setStartTrainee(startTrainee);
        weekReport.setContinueTrainee(continueTrainee);
        weekReport.setTechnicalGradeTrainee(traineeTechGrade);
        weekReport.setConsultantGradeTrainee(traineeConsulGrade);
        weekReport.setTraineeConsultantGradeFlag((byte) 1);
        weekReport.setTraineeTechnicalGradeFlag((byte) 1);
        weekReport.setTraineeStartFlag((byte) 1);
        weekReport.setTraineeStopFlag((byte) 1);
        weekReport.setTraineeContinueFlag((byte) 1);
        weekReport.setMostRecentEdit(LocalDateTime.now());

        weekReportService.updateWeekReport(weekReport);
        return Pages.accessPage(Role.TRAINEE, "redirect:"+Pages.TRAINEE_FEEDBACK_FORM_PAGE_REDIRECT);
    }

}
