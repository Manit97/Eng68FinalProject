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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainerReportController {

    private final TraineeService traineeService;
    private final WeekReportService weekReportService;

    @Autowired
    public TrainerReportController(TraineeService traineeService, WeekReportService weekReportService) {
        this.traineeService = traineeService;
        this.weekReportService = weekReportService;
    }

    @PostMapping("/trainerUpdateReport")
    public ModelAndView postUpdateTrainerReport(ModelMap modelMap, Integer reportId, String trainerTechGrade,
                                                String trainerConsulGrade, String trainerOverallGrade, String trainerComments,
                                                String stopTrainer, String startTrainer, String continueTrainer) {

        WeekReport weekReport = weekReportService.getWeekReportByReportId(reportId).get();
        Integer traineeId = weekReport.getTraineeId();
        Trainee trainee = traineeService.getTraineeByID(traineeId).get();
        List <WeekReport> reports = weekReportService.getReportsByTraineeID(traineeId);

        Collections.reverse(reports);

        weekReport.setStopTrainer(stopTrainer);
        weekReport.setStartTrainer(startTrainer);
        weekReport.setContinueTrainer(continueTrainer);
        weekReport.setTrainerComments(trainerComments);
        weekReport.setTechnicalGradeTrainer(trainerTechGrade);
        weekReport.setConsultantGradeTrainer(trainerConsulGrade);
        weekReport.setOverallGradeTrainer(trainerOverallGrade);
        weekReport.setTrainerCompletedFlag((byte) 1);

        weekReportService.updateWeekReport(weekReport);
        modelMap.addAttribute("traineeId", traineeId);
        modelMap.addAttribute("trainee", trainee);
        modelMap.addAttribute("reports", reports);
        modelMap.addAttribute("now", LocalDateTime.now());

        return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.TRAINER_REPORT),modelMap);
    }

    @GetMapping("/trainerUpdateReport")
    public ModelAndView getUpdateTrainerReport(ModelMap modelMap) {
        return new ModelAndView("redirect:"+Pages.accessPage(Role.TRAINER, Pages.TRAINER_HOME_REDIRECT),modelMap);
    }

    @GetMapping("/trainerFeedbackForm")
    public ModelAndView getTrainerFeedbackForm(ModelMap modelMap) {
        Integer traineeID = 1;
        modelMap.addAttribute("trainee", traineeService.getTraineeByID(traineeID).get());
        Optional<WeekReport> weekReport = weekReportService.getCurrentWeekReportByTraineeID(traineeID);
        if (weekReport.isEmpty()) {
            return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.NO_ITEM_IN_DATABASE_ERROR), modelMap);
        }
        modelMap.addAttribute("trainerFeedback", weekReport.get());

        return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.TRAINER_FEEDBACK_FORM_PAGE), modelMap);
    }

    @PostMapping("/trainerFeedbackForm")
    public ModelAndView getTrainerFeedbackForm(@RequestParam Integer reportId, ModelMap modelMap) {
        WeekReport report = weekReportService.getReportByID(reportId).get();
        Integer traineeId = report.getTraineeId();
        modelMap.addAttribute("trainee", traineeService.getTraineeByID(traineeId).get());
        modelMap.addAttribute("trainerFeedback", weekReportService.getReportByID(reportId).get());

        return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.TRAINER_FEEDBACK_FORM_PAGE), modelMap);
    }

    @GetMapping("/weeklyReportsTrainer")
    public String getTrainerWeeklyReports(@RequestParam Integer traineeId, Model model) {
        Trainee trainee = traineeService.getTraineeByID(traineeId).get();
        List<WeekReport> reports = weekReportService.getReportsByTraineeID(traineeId);
        Collections.reverse(reports);
        model.addAttribute("traineeId", traineeId);
        model.addAttribute("trainee", trainee);
        model.addAttribute("reports", reports);
        model.addAttribute("now", LocalDateTime.now());
        return Pages.accessPage(Role.TRAINER, Pages.TRAINER_REPORT);
    }
}
