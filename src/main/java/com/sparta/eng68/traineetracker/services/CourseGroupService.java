package com.sparta.eng68.traineetracker.services;

import com.sparta.eng68.traineetracker.entities.Course;
import com.sparta.eng68.traineetracker.entities.CourseGroup;
import com.sparta.eng68.traineetracker.repositories.CourseGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseGroupService {
    private final CourseGroupRepository courseGroupRepository;

    @Autowired
    public CourseGroupService(CourseGroupRepository courseGroupRepository) {
        this.courseGroupRepository = courseGroupRepository;
    }

    public Optional<CourseGroup> getGroupByID(Integer id) {
        return (Optional<CourseGroup>) courseGroupRepository.findById(id);
    }
}
