package com.easyservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Worker {

	@Column(length = 20)
	private String workerName;
	@Id
	@GeneratedValue(generator = "worker_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "worker_gen", sequenceName = "worker_seq", initialValue = 300, allocationSize = 1)

	private Integer workerId;
	
	@Column(length = 20)
	private String availability;
	@Column(length = 10)
	private String contactNumber;
	@Column(length = 20)
	private String workType;
	private Integer workingHours;
	private String workerImg;
	@OneToOne(mappedBy = "worker")
	@JsonIgnore
	Task task;
	
	public Worker(String workerName, String availability, String contactNumber, String workType, Integer workingHours,
			String workerImg) {
		super();
		this.workerName = workerName;
		this.availability = availability;
		this.contactNumber = contactNumber;
		this.workType = workType;
		this.workingHours = workingHours;
		this.workerImg = workerImg;
	}

	@Override
	public String toString() {
		return "Worker [workerName=" + workerName + ", availability=" + availability + ", contactNumber="
				+ contactNumber + ", workType=" + workType + ", workingHours=" + workingHours + ", workerImg="
				+ workerImg + ", task=" + task + "]";
	}
	
	
	
}
