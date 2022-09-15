package com.doctorapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Consultation {
	
	@Id
	@GeneratedValue(generator = "cons_id",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cons_id",sequenceName = "cons_seq",initialValue = 100,allocationSize = 1)
	private Integer consultationId;
	private LocalDate localDate;
	@Column(length=20)
	private String availability;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	public Consultation(LocalDate localDate, String availability, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.localDate = localDate;
		this.availability = availability;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Consultation [localDate=" + localDate + ", availability=" + availability + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	
	
}
