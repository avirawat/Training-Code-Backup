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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@NamedQuery(name = "findByBoard",query = "from League l inner join l.board b where b.city=?1")
public class League {
	@Id
	@GeneratedValue(generator = "league_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "league_gen", sequenceName = "league_seq", allocationSize = 1, initialValue = 1)
	private Integer leagueId;
	private String name;
	private String country;
	private Integer duration;
	@OneToOne // (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "boardId")
	private Board board;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "league_id") // to remove the intermediate table and add the coumn to many side
	private Set<Matches> matches;
	@ManyToOne
	@JoinColumn(name = "sports_id")
	Sports sports;

	public League(String name, String country, Integer duration, Board board, Set<Matches> matches, Sports sports) {
		super();
		this.name = name;
		this.country = country;
		this.duration = duration;
		this.board = board;
		this.matches = matches;
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "League [name=" + name + ", country=" + country + ", duration=" + duration + ", board=" + board + "]";
	}
	




}
