package com.acheron.model;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
	@Id
	@GeneratedValue(generator = "sports_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sports_gen", sequenceName = "sports_seq", allocationSize = 1, initialValue = 1)
	private Integer teamId;
	private String teamname;
	private String owner;
	@ManyToOne
	@JoinColumn(name = "match_id")
	Matches matches;
	@Override
	
	
	public String toString() {
		return "Team [teamname=" + teamname + ", owner=" + owner + "]";
	}
	public Team(String teamname, String owner) {
		super();
		this.teamname = teamname;
		this.owner = owner;
	}
	

}
