package com.sparta.eng68.traineetracker.repositories;

import com.sparta.eng68.traineetracker.entities.CourseGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseGroupRepository extends CrudRepository<CourseGroup, Integer> {

}
