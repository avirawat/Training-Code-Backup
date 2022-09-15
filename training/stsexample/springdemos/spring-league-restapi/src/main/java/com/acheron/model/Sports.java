package com.acheron.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Sports {
    @Id
    @GeneratedValue(generator = "sports_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sports_gen",sequenceName = "sports_seq",allocationSize = 1,initialValue = 1)
    private Integer sportId;
	private String name;
	private String origin;
	@OneToMany(mappedBy = "sports")
	Set<League> league;
	public Sports(String name, String origin) {
		super();
		this.name = name;
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "Sports [name=" + name + ", origin=" + origin + "]";
	}


	
}
