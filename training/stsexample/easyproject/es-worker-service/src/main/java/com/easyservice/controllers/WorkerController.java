package com.easyservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyservice.exception.IdNotFoundException;
import com.easyservice.model.Worker;
import com.easyservice.service.IWorkerService;

/**
 * @author AvinashRavat
 *
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/work-service")
public class WorkerController {

	@Autowired
	IWorkerService workService;
	
	// http://localhost:8073/work-service/work
		@PostMapping("/work")
		ResponseEntity<String> addWorker(@RequestBody Worker worker) {
		    workService.addWorker(worker);
		    ResponseEntity<String> response = new ResponseEntity<String>("worker details added", HttpStatus.OK);
			return response;
		}


	
	 //http://localhost:8073/work-service/work/workerId/300
		@DeleteMapping("/work/workerId/{workerId}")
		ResponseEntity<String> deleteById(@PathVariable("workerId") int workerId) throws IdNotFoundException {
			workService.deleteById(workerId);
			ResponseEntity<String> responseDeleteDetails = new ResponseEntity<String>("worker details deleted",
					HttpStatus.OK);
			return responseDeleteDetails;
		}

		// http://localhost:8073/work-service/work/300
		@GetMapping("/work/{workerId}")
		ResponseEntity<Worker> getById(@PathVariable("workerId") int workerId) throws IdNotFoundException {
			Worker workerById = workService.getById(workerId);
			ResponseEntity<Worker> responseGetById = new ResponseEntity<Worker>(workerById, HttpStatus.OK);
			return responseGetById;
		}

		// http://localhost:8073/work-service/work
		@GetMapping("/work")
		ResponseEntity<List<Worker>> getAllWorkers() {
			List<Worker> allWorkerList = workService.getAllWorkers();
			ResponseEntity<List<Worker>> responseAllWorkerList = new ResponseEntity<List<Worker>>(allWorkerList,
					HttpStatus.OK);
			return responseAllWorkerList;
		}
		
		// http://localhost:8073/work-service/work
		@PutMapping("/work")
		ResponseEntity<String> getUpdate(@RequestBody Worker worker) {
			workService.getUpdate(worker);
			ResponseEntity<String> responseUpdate = new ResponseEntity<String>("worker details updated", HttpStatus.OK);
			return responseUpdate;
		}
		

//	// http://localhost:8073/work-service/work/workerName/Ram
//	@GetMapping("/work/workerName/{workerName}")
//	ResponseEntity<List<Worker>> getByWorkerName(@PathVariable("workerName") String workerName)
//			throws WorkerNotFoundException {
//		List<Worker> worker = workService.getByWorkerName(workerName);
//		ResponseEntity<List<Worker>> responsebyWorkerName = new ResponseEntity<List<Worker>>(worker, HttpStatus.OK);
//		return responsebyWorkerName;
//	}
//
//	// http://localhost:8073/work-service/work/status/NA/workType/InteriorPainting
//	@GetMapping("/work/status/{status}/workType/{workType}")
//	ResponseEntity<List<Worker>> getByStatusAndWorkType(@PathVariable("status") String status,
//			@PathVariable("workType") String workType) throws WorkerNotFoundException {
//		List<Worker> worker = workService.getByStatusAndWorkType(status, workType);
//		ResponseEntity<List<Worker>> responsebyStatusAndWorkType = new ResponseEntity<List<Worker>>(worker,
//				HttpStatus.OK);
//		return responsebyStatusAndWorkType;
//	}
//
//	// http://localhost:8073/work-service/work/workDuration/5/workType/InteriorPainting
//	@GetMapping("/work/workDuration/{workDuration}/workType/{workType}")
//	ResponseEntity<List<Worker>> getByDurationAndWorkType(@PathVariable("workDuration") int workDuration,
//			@PathVariable("workType") String workType) throws WorkerNotFoundException {
//		List<Worker> worker = workService.getByDurationAndWorkType(workDuration, workType);
//		ResponseEntity<List<Worker>> responsebyDurationAndWorkType = new ResponseEntity<List<Worker>>(worker,
//				HttpStatus.OK);
//		return responsebyDurationAndWorkType;
//	}
//
//   
//
//	// http://localhost:8073/work-service/work/avl/A
//	@GetMapping("/work/avl/{availability}")
//	ResponseEntity<List<Worker>> getByAvailability(@PathVariable("availability") String availability)
//			throws WorkerNotFoundException {
//		List<Worker> availableWorkers = workService.getByAvailability(availability);
//		ResponseEntity<List<Worker>> responseAvailableWorkerList = new ResponseEntity<List<Worker>>(availableWorkers,
//				HttpStatus.OK);
//		return responseAvailableWorkerList;
//	}
//
//
//	//http://localhost:8073/work-service/work/workDuration/5
//	@GetMapping("/work/workDuration/{workDuration}")
//	ResponseEntity<List<Worker>> getByWorkDuration(@PathVariable("workDuration")int workDuration) throws WorkerNotFoundException{
//		List<Worker> workerByWorkDuration=workService.getByWorkDuration(workDuration);
//		ResponseEntity<List<Worker>> responseWorkerByWorkDuartion = new ResponseEntity<List<Worker>>(workerByWorkDuration,
//				HttpStatus.OK);
//		return responseWorkerByWorkDuartion;
//	}
//	
//	//********* TASK**********
//	
//	//http://localhost:8073/work-service/work/taskName/Floor-Cleaning
//	@GetMapping("/work/taskName/{taskName}")
//	ResponseEntity<List<Worker>> getByTaskName(@PathVariable("taskName")String taskName) throws TaskNotFoundException{
//		List<Worker> workerByTaskName=workService.getByTaskName(taskName);
//		ResponseEntity<List<Worker>> responseWorkerByTaskName= new ResponseEntity<List<Worker>>(workerByTaskName,
//				HttpStatus.OK);
//		return responseWorkerByTaskName;
//	}

}
