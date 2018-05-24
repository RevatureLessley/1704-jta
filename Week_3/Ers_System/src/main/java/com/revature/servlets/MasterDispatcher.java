package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.LoginService;
import com.revature.service.ReimbursementSvce;
import com.revature.service.UpdateEmployeeSvce;


public class MasterDispatcher {
	
	private MasterDispatcher() {}
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("inside dispatcher " + request.getRequestURI());
		switch(request.getRequestURI()) {
		
		case "/Ers_System/login.do":
				System.out.println("inside login.do");
				return LoginService.login(request, response);
		case "/Ers_System/home.do":
			System.out.println("inside home.do");
				return LoginService.login(request, response);
		case "/Ers_System/update.do":
			System.out.println("inside update.do");
				return UpdateEmployeeSvce.updateEmployee(request, response);
		case "/Ers_System/submit.do":
				return ReimbursementSvce.submitReimbursement(request, response);
		case "/Ers_System/empReimbusement.do":
			return ReimbursementSvce.submitReimbursement(request, response);
			
		default:
				return "404.jsp";
		}
	}
}
