package com.shristi.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WebDev implements ICourses {

	@Override
	public List<String> printDetails() {
		
		return Arrays.asList("html","css","js","bootstrap");
	}

}
