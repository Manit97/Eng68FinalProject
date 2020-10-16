package com.sparta.eng68.traineetracker.repositories;

import com.sparta.eng68.traineetracker.entities.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {

}
