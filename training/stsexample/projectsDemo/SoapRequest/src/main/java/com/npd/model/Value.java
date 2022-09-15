package com.npd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Value {
	@JsonProperty("name")
	String name;
	@JsonProperty("values")
	List<String> values;
}
