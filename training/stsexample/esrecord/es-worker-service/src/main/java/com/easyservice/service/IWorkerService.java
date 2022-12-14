package com.easyservice.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.easyservice.exception.IdNotFoundException;
import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Worker;

/**
 * @author AvinashRavat
 *
 */
@Service
public interface IWorkerService {
	
	void deleteById(int workerId) throws IdNotFoundException;
	
	Worker addWorker(Worker worker);
	
	Worker getUpdate(Worker worker);
	
	Worker getById(int workerId) throws IdNotFoundException;
	
	List<Worker> getByTaskName(String taskName) throws TaskNotFoundException;
	
	List<Worker> getAllWorkers();
	
	List<Worker> getByWorkDuration(int workDuration) throws WorkerNotFoundException;
	
	List<Worker> getByWorkerName(String workerName) throws WorkerNotFoundException;
	
	List<Worker> getByStatusAndWorkType(String status, String workType) throws WorkerNotFoundException;

	List<Worker> getByDurationAndWorkType(int workDuration, String workType) throws WorkerNotFoundException;
	
	List<Worker> getByAvailability(String availability) throws WorkerNotFoundException;
	
}
