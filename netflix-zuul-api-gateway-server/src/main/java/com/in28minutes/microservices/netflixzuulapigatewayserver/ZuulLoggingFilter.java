package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	
	private static final Logger log = LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// logging filter core logic
		 HttpServletRequest request = com.netflix.zuul.context.RequestContext.getCurrentContext().getRequest(); 
         log.info("request->{} request uri->{}",request,request.getRequestURI());
		return null;		
	}

	@Override
	public String filterType() {
		// pre,post or error which kind of filter
		return "pre";
	}

	@Override
	public int filterOrder() {
		// priority order for multiple filters e.g log, security filter etc
		return 1;
	}

}
