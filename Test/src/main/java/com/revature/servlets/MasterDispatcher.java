package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.InfoService;
import com.revature.services.LoginService;
import com.revature.services.LogoutService;
import com.revature.services.ReimbursementService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Test/login.do":
			return LoginService.login(request, response);
		case "/Test/logout.do":
			return LogoutService.logout(request, response);
		case "/Test/update.do":
			return InfoService.update(request, response);
		case "/Test/submitReimbursement.do":
			return  ReimbursementService.submitReimbursement(request, response);
		default:
			return "404.jsp";
		}
	}
}
