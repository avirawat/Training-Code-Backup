package com.npd.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sessions {
	@JsonProperty("session_resource")
	public SessionResource sessionResource;
	String jSessionID;
}