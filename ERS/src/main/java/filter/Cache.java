package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Cache implements Filter{
	public Cache() {}
	
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
	    ((HttpServletResponse) httpResponse).setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    ((HttpServletResponse) httpResponse).setHeader("Pragma", "no-cache");
	    ((HttpServletResponse) httpResponse).setDateHeader("Expiresponse", 0);
	    chain.doFilter(request, httpResponse);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {}
}
