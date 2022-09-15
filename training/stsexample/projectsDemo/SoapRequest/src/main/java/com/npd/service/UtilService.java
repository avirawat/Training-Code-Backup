package com.npd.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.npd.filter.CustomFilter;
import com.npd.model.APIConstants;
@Service
public class UtilService {
	
	private static final Logger logger = LogManager.getLogger(UtilService.class);
	
	@Autowired
	Environment env;
	
	
	
	//N
	public boolean isNullOrEmpty(String value) {
		if(value == null || value.isEmpty()) {
			return true;
		}
		return false;
	}
	//N
	public boolean isNullOrEmpty(Object obj) {
		return obj == null ? true : false;
	}
	
	//N
	public String convertSOAPMessageToString(SOAPMessage soapMessage) throws SOAPException, IOException {
		logger.info("covert Soap Message to string");
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		soapMessage.writeTo(bout);
		String message = bout.toString("UTF-8");
		return message;
	}

	
	//N
	public String formOTDSAPI(String s_serviceName) {
		logger.info("Inside Util Service OTDSAPI-1");
		String hostName = env.getProperty("otds.server.host");
		logger.info("Inside Util Service OTDSAPI-2 "+ hostName);
		String apiExt = env.getProperty("otds.api.ext");
		logger.info("Inside Util Service OTDSAPI -3" + apiExt);
		if(!isNullOrEmpty(hostName) && !isNullOrEmpty(apiExt) && !isNullOrEmpty(s_serviceName)) {
			logger.info("Inside Util Service OTDSAPI-4");
			return hostName + apiExt + "/" + s_serviceName;
		}
		return null;
	}
	
	//N
	public String formAppworksGatewayUrl(String s_samlArt) {
		logger.info("Form Appwork Gateway URL");
		String gatewayUrl = env.getProperty("appworks.gateway.url");
		if(!isNullOrEmpty(gatewayUrl) && !isNullOrEmpty(s_samlArt)) {
			return gatewayUrl + "?" + APIConstants.SAMLart.getValue() + "=" + s_samlArt;
		}
		return null;
	}

}
