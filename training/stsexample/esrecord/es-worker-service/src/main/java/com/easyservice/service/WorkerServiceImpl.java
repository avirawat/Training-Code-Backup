package com.easyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyservice.exception.IdNotFoundException;
import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Worker;
import com.easyservice.repository.IWorkRepository;

/**
 * @author AvinashRavat
 *
 */
@Service
public class WorkerServiceImpl implements IWorkerService {

	@Autowired
	IWorkRepository workRepository;

	@Override
	public List<Worker> getByWorkerName(String workerName) throws WorkerNotFoundException {
		List<Worker> workerByWorkerName = workRepository.findByWorkerName(workerName);
		if (workerByWorkerName.isEmpty()) {
			throw new WorkerNotFoundException("Worker Not Found with this Name");
		}
		return workerByWorkerName;
	}

	@Override
	public List<Worker> getByStatusAndWorkType(String status, String workType) throws WorkerNotFoundException {
		List<Worker> workerByStatusAndWorkType = workRepository.findByWStatusAndWorkType(status, workType);
		if (workerByStatusAndWorkType.isEmpty()) {
			throw new WorkerNotFoundException("Worker Not Found with this workType");
		}
		return workerByStatusAndWorkType;
	}

	@Override
	public List<Worker> getByDurationAndWorkType(int workDuration, String workType) throws WorkerNotFoundException {
		List<Worker> workerByDurationAndWorkType = workRepository.findByDurationAndWorkType(workDuration, workType);
		if (workerByDurationAndWorkType.isEmpty()) {
			throw new WorkerNotFoundException("Worker Not Found with this workType");
		}
		return workerByDurationAndWorkType;
	}

	@Override
	public void deleteById(int workerId) throws IdNotFoundException {
		workRepository.getById(workerId);
		workRepository.deleteById(workerId);

	}

	@Override
	public Worker getById(int workerId) throws IdNotFoundException {
		return workRepository.findById(workerId).orElseThrow(() -> new IdNotFoundException("Worker Id Not found"));

	}

	@Override
	public List<Worker> getAllWorkers() {
		return workRepository.findAll();
	}

	@Override
	public List<Worker> getByAvailability(String availability) throws WorkerNotFoundException {
		List<Worker> allAvailableWorker = workRepository.findByAvailability(availability);
		if (allAvailableWorker.isEmpty()) {
			throw new WorkerNotFoundException("Workers not available");
		}
		return allAvailableWorker;
	}

	@Override
	public Worker getUpdate(Worker worker) {
		return workRepository.save(worker);
	}

	@Override
	public List<Worker> getByWorkDuration(int workDuration) throws WorkerNotFoundException {
		List<Worker> workerByWorkDuration=workRepository.findByWorkDuration(workDuration);
		if(workerByWorkDuration.isEmpty()) {
			throw new WorkerNotFoundException("Workers not available");
		}
		return workerByWorkDuration;
	}

	@Override
	public List<Worker> getByTaskName(String taskName) throws TaskNotFoundException{
		List<Worker> workerByTaskName=workRepository.findByTaskName(taskName);
		if(workerByTaskName.isEmpty()) {
			throw new TaskNotFoundException("Workers not available");
		}
		return workerByTaskName;
	}

	@Override
	public Worker addWorker(Worker worker) {
		return workRepository.save(worker);
	}

}
