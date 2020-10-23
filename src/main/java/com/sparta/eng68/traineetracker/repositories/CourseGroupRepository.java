package com.sparta.eng68.traineetracker.repositories;

import com.sparta.eng68.traineetracker.entities.CourseGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseGroupRepository extends CrudRepository<CourseGroup, Integer> {

    Optional<CourseGroup> findFirstByGroupIdOrderByCurrentWeekDesc(Integer groupId);

}
