package com.shristi.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Trainer {
	
	private String trainerName;
	private int trainerId;
	
	public String getTrainerName() {
		return trainerName;
	}
	@Value("${course.trainer.trainerName}")
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getTrainerId() {
		return trainerId;
	}
	@Value("${course.trainer.trainerId}")
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	@Override
	public String toString() {
		return "Trainer [trainerName=" + trainerName + ", trainerId=" + trainerId + "]";
	}
	
	
	
}
