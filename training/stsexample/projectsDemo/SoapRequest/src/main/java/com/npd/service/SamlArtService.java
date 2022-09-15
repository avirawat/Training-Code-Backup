package com.npd.service;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamlArtService {
	
	private static final Logger logger = LogManager.getLogger(SamlArtService.class);
	
	@Autowired
	static UtilService utilService;
	
	public static String createSAMLRequest(String psaUserName, String psaPassword, String gateWayURL) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		SOAPEnvelope envelope = soapPart.getEnvelope();

		SOAPHeader soapHeader = envelope.getHeader();
		SOAPElement security = soapHeader.addChildElement("Security", "wsse",
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

		SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
		usernameToken.addAttribute(new QName("xmlns:wsu"),
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

		SOAPElement username = usernameToken.addChildElement("Username", "wsse");
		username.addTextNode(psaUserName.trim());

		SOAPElement password = usernameToken.addChildElement("Password", "wsse");
		password.addTextNode(psaPassword.trim());

		SOAPBody soapBody = envelope.getBody();
		SOAPElement requestElement = soapBody.addChildElement("Request", "samlp",
				"urn:oasis:names:tc:SAML:1.0:protocol");
		requestElement.setAttribute("MajorVersion", "1");
		requestElement.setAttribute("MinorVersion", "1");
		requestElement.setAttribute("IssueInstant", "2019-11-16T14:27:44Z");
		requestElement.setAttribute("RequestID", "a76d2e56a8-d878-7e62-1297-4102a06856b");
		SOAPElement authendicationQueryElement = requestElement.addChildElement("AuthenticationQuery", "samlp");
		SOAPElement subjectElement = authendicationQueryElement.addChildElement("Subject", "saml",
				"urn:oasis:names:tc:SAML:1.0:assertion");
		SOAPElement nameIdentifierElement = subjectElement.addChildElement("NameIdentifier", "saml");
		nameIdentifierElement.setAttribute("Format", "urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified");
		nameIdentifierElement.addTextNode(psaUserName);
		soapMessage.saveChanges();
		SOAPMessage soapResponse = soapConnection.call(soapMessage, gateWayURL);

		String samlString = getSAMLResponse(utilService.convertSOAPMessageToString(soapResponse));   // .getSOAPResponse(soapResponse));
		return samlString;
	}

	public static String getSAMLResponse(String response) throws Exception {
		StringBuilder str = new StringBuilder();
		str.append(response);
		String startString = "<samlp:AssertionArtifact xmlns:samlp=\"urn:oasis:names:tc:SAML:1.0:protocol\">";
		int start = str.indexOf(startString) + startString.length();
		int end = str.indexOf("</samlp:AssertionArtifact>");
		logger.error("subString" + str);
		logger.error("start" + start);
		logger.error("end" + end);
		String saml = str.substring(start, end);
		System.out.print("AssertionArtifact = " + saml);
		return saml;
	}


}
