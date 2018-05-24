package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ReimbSvce;

public class AjaxDispatcher {

	private AjaxDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Ers_System/viewReimbursement.ajax":
			System.out.println("inside ajaxDispatcher");
			return ReimbSvce.getAllReimbursement();
		default:
			return new String("Not implemented");
		}
	}
}
