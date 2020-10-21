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
    public ModelAndView postUpdateTrainerReport(ModelMap modelMap, Integer reportId, String stopTrainee,
                                                String startTrainee, String continueTrainee, String trainerComments, String stopTrainer,
                                                String startTrainer, String continueTrainer) {

        WeekReport weekReport = weekReportService.getWeekReportByReportId(reportId).get();

        weekReport.setStopTrainer(stopTrainer);
        weekReport.setStartTrainer(startTrainer);
        weekReport.setContinueTrainer(continueTrainer);
        weekReport.setTrainerComments(trainerComments);
        weekReport.setTrainerCompletedFlag((byte) 1);

        weekReportService.updateWeekReport(weekReport);

        return new ModelAndView("redirect:"+Pages.accessPage(Role.TRAINER, Pages.TRAINER_HOME_REDIRECT),modelMap);
    }

    @GetMapping("/trainerUpdateReport")
    public ModelAndView getUpdateTrainerReport(ModelMap modelMap) {
        return new ModelAndView("redirect:"+Pages.accessPage(Role.TRAINER, Pages.TRAINER_HOME_REDIRECT),modelMap);
    }

    @GetMapping("/trainerFeedbackForm")
    public ModelAndView getTrainerFeedbackForm(ModelMap modelMap) {
        Optional<WeekReport> weekReport = weekReportService.getCurrentWeekReportByTraineeID(1);
        if (weekReport.isEmpty()) {
            return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.NO_ITEM_IN_DATABASE_ERROR), modelMap);
        }
        modelMap.addAttribute("trainerFeedback", weekReport.get());

        return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.TRAINER_FEEDBACK_FORM_PAGE), modelMap);
    }

    @PostMapping("/trainerFeedbackForm")
    public ModelAndView getTrainerFeedbackForm(@RequestParam Integer traineeId, ModelMap modelMap) {
        modelMap.addAttribute("weekReport", weekReportService.getCurrentWeekReportByTraineeID(traineeId).get());

        return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.TRAINER_FEEDBACK_FORM_PAGE), modelMap);
    }

    @GetMapping("/weeklyReportsTrainer")
    public String getTrainerWeeklyReports(@RequestParam Integer traineeId, Model model, Principal principal) {
        Trainee trainee = traineeService.getTraineeByID(traineeId).get();
        List<WeekReport> reports = weekReportService.getReportsByTraineeID(traineeId);
        Collections.reverse(reports);
        model.addAttribute("trainee", trainee);
        model.addAttribute("reports", reports);
        model.addAttribute("now", LocalDateTime.now());
        //return Pages.accessPage(Role.TRAINER, Pages.TRAINER_REPORT);
        return "trainer/trainerReport";
    }
}
