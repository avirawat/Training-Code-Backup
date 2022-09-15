package com.npd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	@JsonProperty("name")
	String name;
	@JsonProperty("userPartitionID")
	String userPartitionID;
	@JsonProperty("location")
	String location;
	@JsonProperty("id")
	String id;
	@JsonProperty("values")
	List<Value> values;
}
