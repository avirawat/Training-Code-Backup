package com.npd.model;

public enum APIConstants {

	COOKIE("Cookie"),
    OTDS_TICKET("OTDSTicket"),
    OTDS_SSO("OTDSSSO"),
	OTMM_API("otmmapi"),
	OTDS_API("otdsws"),
	VERSION("v5"),
	REST("rest"),
	USERS("users"),
	CURRENT_USER("me"),
	MANAGER("Manager1"),
	CONTENT_TYPE("CONTENT_TYPE"),
	ID("ID"),
	ITEM_ID("ITEM_ID"),
	CURRENTUSER("currentuser"),
	CURRENTUSERID("currentUserId"),
	SAMLart("SAMLart"),
	USER_DN("UserDN");
	
	private String value;
	
	APIConstants(final String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
