package com.cg.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.dao.TraineeDAO;
import com.cg.project.entity.Trainee;

@Service
public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	private TraineeDAO traineeDAO;

	@Override
	@Transactional
	public List<Trainee> getTrainees() {
		return traineeDAO.getTrainees();
	}

	@Override
	@Transactional
	public void saveTrainee(Trainee theTrainee) {
		traineeDAO.saveTrainee(theTrainee);
		
	}

	@Override
	@Transactional
	public Trainee getTrainee(int id) {
		return traineeDAO.getTrainee(id);
	}

	@Override
	@Transactional
	public void updateTrainee(Trainee theTrainee) {
		traineeDAO.updateTrainee(theTrainee);		
	}

	@Override
	@Transactional
	public void deleteTrainee(int id) {
		traineeDAO.deleteTrainee(id);
		
	}

	
}
