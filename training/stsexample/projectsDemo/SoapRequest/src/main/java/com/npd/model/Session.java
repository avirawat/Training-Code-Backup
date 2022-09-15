package com.npd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Session {
	@JsonProperty("domain_name")
	public String domainName;
	String id;
	@JsonProperty("local_session")
	String localSession;
	@JsonProperty("login_name")
	String loginName;
	@JsonProperty("message_digest")
	String messageDigest;
	@JsonProperty("role_name")
	String roleName;
	@JsonProperty("user_full_name")
	String userFullName;
	@JsonProperty("user_id")
	String userId;
	@JsonProperty("user_role_id")
	String userRoleId;
	@JsonProperty("validation_key")
	String validationKey;
}
