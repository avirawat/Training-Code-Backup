package com.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="appusers")
public class AppUsers {
	@Id
	@GeneratedValue
	private Integer userId;
	@Column(length=20,unique = true)
	private String username;
	private String password;
	@Column(length=20,unique = true)
	private String email;
	
	
}
