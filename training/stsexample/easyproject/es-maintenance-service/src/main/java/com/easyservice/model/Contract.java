package com.easyservice.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Contract {

	@Column(length = 20)
	private String contractName;
	@Id
	@GeneratedValue(generator = "contract_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contract_gen", sequenceName = "contract_seq", initialValue = 1, allocationSize = 1)
	private Integer contractId;
	@Column(length = 20)
	private String contractorName;
	private LocalDate startDate;
	private LocalDate endDate;
	private Status cStatus;
	private Priority cPriority;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contract_id")
	@JsonIgnore
	Set<Maintenance> maintenanceList;
	private String contractImg;

	public Contract(String contractName, String contractorName, LocalDate startDate, LocalDate endDate, Status cStatus,
			Priority cPriority, Set<Maintenance> maintenanceList, String contractImg) {
		super();
		this.contractName = contractName;
		this.contractorName = contractorName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cStatus = cStatus;
		this.cPriority = cPriority;
		this.maintenanceList = maintenanceList;
		this.contractImg = contractImg;
	}

	@Override
	public String toString() {
		return "Contract [contractName=" + contractName + ", contractorName=" + contractorName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", cStatus=" + cStatus + ", cPriority=" + cPriority
				+ ", maintenanceList=" + maintenanceList + ", contractImg=" + contractImg + "]";
	}

}
