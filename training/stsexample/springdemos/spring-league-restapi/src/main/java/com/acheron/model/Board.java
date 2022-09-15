         package com.acheron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Board {
    @Id
    @GeneratedValue(generator = "board_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "board_gen",sequenceName = "board_seq",allocationSize = 1,initialValue = 1)
    private Integer boardId;
	private String city;
	private String occupation;
	//use mapped by if you want to have the id only on the primary side
	//use join colum if you want the foreignkey(id) on both sides
	@OneToOne(mappedBy = "board")//league is the owner of the class we are using the instance variable of league 
	//@JoinColumn(name = "league_id")// to have the coulmn id on both tables
	League league;
	public Board(String city, String occupation) {
		super();
		this.city = city;
		this.occupation = occupation;
	}
	@Override
	public String toString() {
		return "Board [city=" + city + ", occupation=" + occupation + "]";
	}
	
	
}
