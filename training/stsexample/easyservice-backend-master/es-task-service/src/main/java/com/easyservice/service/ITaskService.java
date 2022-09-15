package com.easyservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Maintenance;
import com.easyservice.model.Task;
import com.easyservice.model.Worker;

@Service
public interface ITaskService {

	// crud

	Task addTask(Task task);

	void deleteTask(int taskId) throws TaskNotFoundException;

	void updateTask(Task task);

	Task getById(int taskId) throws TaskNotFoundException;

	List<Task> getAllTask();

	int assignTaskToMaintenance(int maintenanceId, int taskId);

	int assignTaskToWorker(int workerId, int taskId);

	int workerStatus(String availability, int workerId);

	Worker getByWorkerId(int workerId) throws WorkerNotFoundException;

	List<Task> getByMaintenanceId(int maintenanceId) throws TaskNotFoundException;

//	Task getByOrganiserAndStatus(String organiser, Status tStatus) throws TaskNotFoundException;
//
//	List<Task> getByTaskStartDateAndEndDate(LocalDate tStartDate, LocalDate tEndDate) throws TaskNotFoundException;
//
//	// worker
//	
//	Worker getByWorkerName(String workerName) throws WorkerNotFoundException;
//
//	Worker getByStatusAndWorkType(String status, String workType) throws WorkerNotFoundException;
//
//	Worker getByDurationAndWorkType(int workDuration, String workType) throws WorkerNotFoundException;
//	
//	List<Worker> allWorkerList();
//	
//	List<Worker> getByAvailability(String availability) throws WorkerNotFoundException;
//	

//	
//	Maintenance maintenanceById(int maintenanceId);
//	int assignTask(int maintenanceId ,int taskId);
////	
//	Worker unAssignWorkToWorker(Worker worker);
}
