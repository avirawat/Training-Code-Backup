package com.acheron.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Matches {
	@Id
	@GeneratedValue(generator = "match_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "match_gen", sequenceName = "match_seq", allocationSize = 1, initialValue = 1)
	private Integer matchId;
	private String name;
	private String stadium;
	@ManyToOne
	@JoinColumn(name = "league_id")//to use the existing column that is created in unidirectional relation
	League league;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "match_id")
	Set<Team> teamList;

	public Matches(String name, String stadium) {
		super();
		this.name = name;
		this.stadium = stadium;
	}

	@Override
	public String toString() {
		return "Matches [name=" + name + ", stadium=" + stadium + ", teamList=" + teamList + "]";
	}

	public Matches(String name, String stadium, Set<Team> teamList) {
		super();
		this.name = name;
		this.stadium = stadium;
		this.teamList = teamList;
	}

	




}
