package com.shristi.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Features {
	private String os;
	private String processor;


	public String getOs() {
		return os;
	}

	@Value("android")
	public void setOs(String os) {
		this.os = os;
	}

	public String getProcessor() {
		return processor;
	}

	@Value("snap dragon")
	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Override
	public String toString() {
		return "Features [os=" + os + ", processor=" + processor + "]";
	}
	
	
}