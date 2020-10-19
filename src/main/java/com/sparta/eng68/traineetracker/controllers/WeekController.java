package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.entities.Trainer;
import com.sparta.eng68.traineetracker.entities.User;
import com.sparta.eng68.traineetracker.entities.WeekReport;
import com.sparta.eng68.traineetracker.services.*;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WeekController {

    private final CourseGroupService courseGroupService;
    private final TraineeService traineeService;
    private final UserService userService;
    private final TrainerService trainerService;
    private final WeekReportService weekReportService;

    @Autowired
    public WeekController(CourseGroupService courseGroupService, TraineeService traineeService, UserService userService, TrainerService trainerService, WeekReportService weekReportService) {
        this.courseGroupService = courseGroupService;
        this.traineeService = traineeService;
        this.userService = userService;
        this.trainerService = trainerService;
        this.weekReportService = weekReportService;
    }

    @GetMapping("/newWeek")
    public ModelAndView addNewWeek(ModelMap modelMap, Principal principal){
        String username = principal.getName();
        System.out.println(username);
        User user = userService.getUserByUsername(username);
//        if (user.getRole()!= Role.TRAINER){
//            return new ModelAndView(Pages.accessPage(Role.ANY,Pages.ACCESS_ERROR), modelMap);
//        }
        Optional<Trainer> trainerOptional = trainerService.getTrainerByUsername(username);
        Trainer trainer = trainerOptional.get();
        int group_id = trainer.getGroupId();
        courseGroupService.incrementWeek(group_id);
        int week_num = courseGroupService.getWeekByGroupId(group_id);
        List<Trainee> trainees = traineeService.getTraineesByGroupId(group_id);
        List<WeekReport> weekReports = new ArrayList<>();
        for(Trainee trainee: trainees){
           WeekReport weekReport = new WeekReport();
           weekReport.setTraineeId(trainee.getTraineeId());
           weekReport.setWeekNum(week_num);

           LocalDate deadlineDay =LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
           LocalDateTime deadline = deadlineDay.atTime(18, 30);
           weekReport.setDeadline(deadline);
           weekReports.add(weekReport);
        }
        weekReportService.createReports(weekReports);
        return new ModelAndView(Pages.accessPage(Role.TRAINER,Pages.TRAINER_HOME), modelMap);
    }
}
