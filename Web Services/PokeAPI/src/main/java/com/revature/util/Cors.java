package com.revature.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Cors implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String origin = "Access-Control-Allow-Origin";
		String method = "Access-Control-Allow-Methods";
		String url = "http://localhost:4200";
		
		((HttpServletResponse) response).setHeader(origin, url);
		((HttpServletResponse) response).setHeader(method, "GET, PUT, POST");
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	public void destroy() {}
	
}
