package com.npd.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.npd.model.APIConstants;
import com.npd.service.AuthenticationService;
import com.npd.service.SamlArtService;
import com.npd.service.UtilService;


@Component
@WebFilter(filterName="customerFilterForIndexerApplication",urlPatterns= {"/*"})
public class CustomFilter implements Filter{

	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	Environment env;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	SamlArtService samlArtService;
	
	private static final Logger logger = LogManager.getLogger(CustomFilter.class);
	
	private static final String FILTER_APPLIED = "__spring_security_demoFilter_filterApplied";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Inside Do Filter ");
		if (request.getAttribute(FILTER_APPLIED) != null) {
            chain.doFilter(request, response);
            return ;
        }
		
		request.setAttribute(FILTER_APPLIED, response);
		
		if(request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String OTDSTicket = httpRequest.getHeader(APIConstants.OTDS_SSO.getValue());
			logger.info("The OTDS ticket is" + OTDSTicket);
			String samlart = httpRequest.getHeader(APIConstants.SAMLart.getValue());
//			String psaUserName="Raj";
//			String psaPassword="OTMM|0gi^";
//			String gateWayURL=env.getProperty("appworks.gateway.url");
//			String samlart = null;
//			try {
//				samlart = samlArtService.createSAMLRequest(psaUserName, psaPassword, gateWayURL);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			logger.info("SAMLart Received: " + samlart);
			String currentUser = httpRequest.getHeader(APIConstants.CURRENTUSERID.getValue());
			logger.info("Validating the current user: " + currentUser);
			
			if(httpRequest.getRequestURI().equalsIgnoreCase("/test")) {
				logger.info("Request for Test URL");
				chain.doFilter(request, response);
			}else if(!utilService.isNullOrEmpty(OTDSTicket) && !utilService.isNullOrEmpty(currentUser)) {
				logger.info("Validation through OTDS Tocken Authentication Starts.1");
				
				if (OTDSTicket == null || OTDSTicket.isEmpty()) {
					((HttpServletResponse) response).sendError(HttpServletResponse.SC_NOT_FOUND);
				}
				try {
					boolean isUser = authenticationService.getCurrentUser(OTDSTicket, currentUser);

					if (!isUser) {
						logger.error("User Access Denied" +" "+ currentUser);
						((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, "User Access Denied");
					} else {
						logger.error("User Access Granted 1" +" "+ currentUser);
						//boolean isUserDemo = authenticationService.soapCall(samlart, currentUser);
						chain.doFilter(request, response);
					}
				} catch (Exception e) {
					StringWriter sw = new StringWriter();
					e.fillInStackTrace().printStackTrace(new PrintWriter(sw));
					logger.error("Error : " + sw.toString());
					((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not a Valid Path");
				}
			}else if(!utilService.isNullOrEmpty(samlart) && !utilService.isNullOrEmpty(currentUser)) {
				logger.info("Validation through SAML Authentication Starts.2");
				
				boolean isUser = authenticationService.soapCall(samlart, currentUser);
				
				if (!isUser) {
					logger.error("User Access Denied " +" "+ currentUser);
					((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, "User Access Denied");
				} else {
					logger.error("User Access Granted 2" +" "+ currentUser);
					chain.doFilter(request, response);
				}
			}else {
				logger.error("No Valid Authentication Headers found for current user.");
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_EXPECTATION_FAILED, "Request could not meet the expectation given in the request header.");
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
