package com.npd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentUserDetails {

	@JsonProperty("user")
	User user;
	@JsonProperty("isAdmin")
	boolean isAdmin;
	
}
