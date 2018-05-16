package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MasterServlet() {
    	super();
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		System.out.println("Inside masterServlet doPost");
		System.out.println("inside masterServlet URI= " + request.getRequestURI());
		request.getRequestDispatcher(MasterDispatcher.process(request, response)).forward(request, response);
		
		/*System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		
		System.out.println("request.RequesURI()--->		:" + request.getRequestURI());
		System.out.println("request.getRequestURL()-----> " + request.getRequestURL());
		
		request.getRequestDispatcher(MasterDispatcher.process(request, response)).forward(request, response);
		
		System.out.println("Inside MasterServlet {returned frm process(req,res)} "+ MasterDispatcher.process(request, response));
	
		System.out.println("finished doPonst in MasterServlet");*/

		//System.out.println(MasterDispatcher.process(request, response));	// returns /home.do
	
	}

}
