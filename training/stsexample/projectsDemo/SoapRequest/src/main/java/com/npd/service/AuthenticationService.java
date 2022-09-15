package com.npd.service;

import java.util.List;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.NodeList;

import com.npd.model.APIConstants;
import com.npd.model.CurrentUserDetails;
import com.npd.model.Sessions;
import com.npd.model.Value;

@Service
public class AuthenticationService {
	
	@Autowired
	Environment env;
	
	@Autowired
	UtilService utilService;
	
	private static final Logger logger = LogManager.getLogger(AuthenticationService.class);
	
	public boolean getCurrentUser(String otdsTicket, String currentUser) throws Exception {
		
		logger.info("Inside GetCurrentUser service-1");

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add(APIConstants.COOKIE.getValue(), APIConstants.OTDS_TICKET.getValue() + "=" + otdsTicket);
		requestHeaders.add(APIConstants.COOKIE.getValue(), APIConstants.CURRENTUSERID.getValue() + "=" + currentUser);

		HttpEntity requestEntity = new HttpEntity<>(requestHeaders);

		ResponseEntity<CurrentUserDetails> response;
		try {
			response = restTemplate.exchange(utilService.formOTDSAPI(APIConstants.CURRENTUSER.getValue()), HttpMethod.GET, requestEntity,
					CurrentUserDetails.class);
			logger.info("Inside GetCurrentUser service-2");
			List<Value> Values = response.getBody().getUser().getValues();
			for (Value value : Values) {
				logger.info("Inside GetCurrentUser service-3");
				if (value == null || value.getName().equalsIgnoreCase("")) {
					return false;
				} else if (value.getName() != null && value.getName().equalsIgnoreCase("oTExternalID1")
						|| value.getName().equalsIgnoreCase("oTExternalID3")) {
					logger.info("Inside GetCurrentUser service-4");
					List<String> currentUserValue = value.getValues();
					for (String user : currentUserValue) {
						logger.info("Inside GetCurrentUser service-5");
						if (user.equalsIgnoreCase(currentUser)) {
							return true;
						}
					}
				}
			}
			return false;
		} catch (

		RestClientException e) {
			throw new Exception(e);
		}
	}
	
	public boolean soapCall(String smalArt, String currentUser) {
		SOAPConnectionFactory soapConnectionFactory;
		
		String endPointURL = utilService.formAppworksGatewayUrl(smalArt);
		logger.info("endpint url "+endPointURL);
		if(utilService.isNullOrEmpty(endPointURL)) {
			return false;
		}
		try {
			   logger.info("Inside soap Call with value:");
			soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
		
			SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), endPointURL);
			
			// Print the SOAP Response
            logger.info("Response SOAP Message:");
            logger.info(utilService.convertSOAPMessageToString(soapResponse));
            
            //Get User Dn to compare input user dn
			SOAPBody soapBody = soapResponse.getSOAPBody();
			NodeList nodeList = soapBody.getElementsByTagName(APIConstants.USER_DN.getValue());
			Node node = (Node) nodeList.item(0);
			
			String userDn = node.getValue();
			logger.error("Current User DN from GetUserDetaiils Response: " + userDn);
			
			return userDn.equalsIgnoreCase(currentUser);
			
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	private void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();

            /*
            Constructed SOAP Request Message:
            <SOAP:Envelope xmlns:SOAP='http://schemas.xmlsoap.org/soap/envelope/'>
			    <SOAP:Body>
			        <GetUserDetails xmlns='http://schemas.cordys.com/notification/workflow/1.0'/>
			    </SOAP:Body>
			</SOAP:Envelope>
            */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetUserDetails", null, "http://schemas.cordys.com/notification/workflow/1.0");
    }
	
	private SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        logger.info("GetUserRequest:");
        logger.info(utilService.convertSOAPMessageToString(soapMessage));

        return soapMessage;
    }

	public Sessions createSession(String UserName, String Password) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		String url = env.getProperty("otmm.server.host") + "/otmmapi/" + env.getProperty("otmm.server.version")
				+ "/sessions";

		logger.error("sessions url " + url);
		requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> requestFormData = new LinkedMultiValueMap<String, String>();
		requestFormData.add("username", UserName);
		requestFormData.add("password", Password);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
				requestFormData, requestHeaders);

		try {
			HttpEntity<Sessions> response = restTemplate.postForEntity(url, request, Sessions.class);
			Sessions sessionsObj = response.getBody();
			String cookie = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
			sessionsObj.setJSessionID(cookie);
			return sessionsObj;

		} catch (HttpServerErrorException | HttpClientErrorException e) {
			logger.error("Failed while Authentication with error" + e.getResponseBodyAsString());
			throw new HttpServerErrorException(e.getStatusCode());
		}

	}


}
