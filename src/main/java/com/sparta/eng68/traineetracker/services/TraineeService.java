package com.sparta.eng68.traineetracker.services;

import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;

    @Autowired
    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public List<Trainee> getAllTrainees() {
        return (List<Trainee>) traineeRepository.findAll();
    }

    public Optional<Trainee> getTraineeByID(Integer id) {
        return traineeRepository.findById(id);
    }

    public Optional<Trainee> getTraineeByUsername(String username){
        return traineeRepository.findTraineeByUsername(username);
    }
}
