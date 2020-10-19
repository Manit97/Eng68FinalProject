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
        return (Optional<Trainee>) traineeRepository.findById(id);
    }

    public Trainee changeTraineeCourseGroupByID(int traineeId, int newGroupId) {
        Trainee trainee = getTraineeByID(traineeId).get();
        trainee.setGroupId(newGroupId);
        trainee = traineeRepository.save(trainee);
        return trainee;

    public List<Trainee> getTraineesByGroupId(int group_id){
        List<Trainee> trainees = traineeRepository.findAllByGroupId(group_id);
        return trainees;
    }
}
