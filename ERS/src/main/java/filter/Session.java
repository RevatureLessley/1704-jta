package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session implements Filter{
	public Session() {}
	
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if(session != null)
			chain.doFilter(request, response);
		else {
			request.setAttribute("message", "session lost; relogin");
			request.getRequestDispatcher("index.do").forward(request, response);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {}
}
