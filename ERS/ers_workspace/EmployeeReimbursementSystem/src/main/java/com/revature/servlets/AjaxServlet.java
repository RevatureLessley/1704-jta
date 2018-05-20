package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.logging.LogThis;

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			if (request.getSession().getAttribute("currentEmployee") == null) {
				response.setContentType("text/html");

				LogThis.info("MasterDispatcher if currentEmployee == null");
				response.sendRedirect("404.jsp");

				return;
			}
		} catch (Exception e) {
			response.sendRedirect("404.jsp");

			return;
		}

		
		response.setContentType("application/json");
		
		// Get a reference to the ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		// Write the POJO as JSON to the response
		response.getWriter().write(
				mapper.writeValueAsString(AjaxDispatcher.process(request, response)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
