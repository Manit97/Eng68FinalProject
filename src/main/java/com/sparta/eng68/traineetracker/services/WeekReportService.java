package com.sparta.eng68.traineetracker.services;

import com.sparta.eng68.traineetracker.entities.WeekReport;
import com.sparta.eng68.traineetracker.repositories.WeekReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeekReportService {
    private final WeekReportRepository weekReportRepository;

    @Autowired
    public WeekReportService(WeekReportRepository weekReportRepository) {
        this.weekReportRepository = weekReportRepository;
    }

    public List<WeekReport> getAllReports() {
        return (List<WeekReport>) weekReportRepository.findAll();
    }

    public Optional<WeekReport> getGroupByID(Integer id) {
        return (Optional<WeekReport>) weekReportRepository.findById(id);
    }
}
