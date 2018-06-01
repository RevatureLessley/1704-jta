package com.revature.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	public CORSFilter() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("HTTP Method: " + ((HttpServletRequest) request).getMethod());
		
		// Relax CORS at the following domain
		((HttpServletResponse) response ).setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		
		// Allow the following HTTP methods from the other domain
		((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "GET, PUT, POST");
		
		// Pass the request along the chain
		chain.doFilter(request, response);
		
		
	}
	
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	public void destroy() {}
	

}
