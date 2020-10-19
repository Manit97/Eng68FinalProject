package com.sparta.eng68.traineetracker.services;

import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.entities.WeekReport;
import com.sparta.eng68.traineetracker.repositories.CourseGroupRepository;
import com.sparta.eng68.traineetracker.repositories.TraineeRepository;
import com.sparta.eng68.traineetracker.repositories.WeekReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeekReportService {
    private final WeekReportRepository weekReportRepository;
    private final CourseGroupRepository courseGroupRepository;
    private final TraineeRepository traineeRepository;

    @Autowired
    public WeekReportService(WeekReportRepository weekReportRepository, CourseGroupRepository courseGroupRepository,
            TraineeRepository traineeRepository) {
        this.weekReportRepository = weekReportRepository;
        this.courseGroupRepository = courseGroupRepository;
        this.traineeRepository = traineeRepository;
    }

    public List<WeekReport> getAllReports() {
        return (List<WeekReport>) weekReportRepository.findAll();
    }

    public Optional<WeekReport> getGroupByID(Integer id) {
        return (Optional<WeekReport>) weekReportRepository.findById(id);
    }

    public Optional<WeekReport> getCurrentWeekReportByTraineeID(Integer traineeId) {
        Trainee trainee = traineeRepository.findById(traineeId).get();
        Integer currentWeek = courseGroupRepository.findFirstByGroupIdOrderByCurrentWeekDesc(trainee.getGroupId()).get().getCurrentWeek();
        Optional<WeekReport> weekReport = weekReportRepository.findFirstByWeekNumAndTraineeId(currentWeek, traineeId);

        return weekReport;
    }

    public void updateWeekReport(WeekReport weekReport) {
        weekReportRepository.save(weekReport);
    }
}
