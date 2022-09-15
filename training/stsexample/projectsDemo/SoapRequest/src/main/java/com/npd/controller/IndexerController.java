package com.npd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npd.model.UserDemo;
import com.npd.service.AuthenticationService;

@RestController
@EnableAsync
public class IndexerController {
	
	@Autowired(required = true)
	AuthenticationService authenticationService;
	
	private static final Logger logger = LogManager.getLogger(IndexerController.class);
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test()
	{
		logger.info("Inside Testing");
		return "Tested Successfully";
	}


	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String searchIndexer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Inside Testing Checking Controller Token");
		return "test";
	}
	
	//cn=Raj,cn=organizational users,o=NPD,cn=cordys,cn=TEST,o=HBC.internal
//	@RequestMapping(value="/getDetails", method = RequestMethod.POST)
//	public boolean getDetails(@RequestBody(required=true) UserDemo userDemo,HttpServletRequest request, HttpServletResponse response) throws Exception {
//		logger.info("Inside Controller get Details");
//		return authenticationService.soapCall(null,"Will@NPD Team");
//				}
	
	
}
