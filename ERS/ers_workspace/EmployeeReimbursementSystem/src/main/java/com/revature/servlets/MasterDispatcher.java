package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.factories.LoginFactory;
import com.revature.logging.InvalidLoginException;
import com.revature.logging.LogThis;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.FinancialManagerService;
import com.revature.service.NavigationService;
import com.revature.service.ReimbursementService;

public class MasterDispatcher {

	private MasterDispatcher() {
	}

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		LogThis.info("MasterDispatcher process");

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		switch (request.getRequestURI()) {
		case "/EmployeeReimbursementSystem/main.do":
			LogThis.info("MasterDispatcher main.do");
			return NavigationService.main(request);

		case "/EmployeeReimbursementSystem/login.do":
			LogThis.info("MasterDispatcher login.do");
			return NavigationService.login(request);

		case "/EmployeeReimbursementSystem/logout.do":
			LogThis.info("MasterDispatcher logout.do");
			return NavigationService.logout(request, response);

		case "/EmployeeReimbursementSystem/finManHome.do":
			try {
				if (request.getSession().getAttribute("currentEmployee") == null) {

					LogThis.info("MasterDispatcher if currentEmployee == null");
					return "main.do";
				}
			} catch (Exception e) {
				return "main.do";
			}

			LogThis.info("MasterDispatcher finManHome.do");
			return FinancialManagerService.finManHome(request);

		case "/EmployeeReimbursementSystem/employeeHome.do":
			try {
				if (request.getSession().getAttribute("currentEmployee") == null) {

					LogThis.info("MasterDispatcher if currentEmployee == null");
					return "main.do";
				}
			} catch (Exception e) {
				return "main.do";
			}

			LogThis.info("MasterDispatcher employeeHome.do");
			return EmployeeService.employeeHome(request);

		case "/EmployeeReimbursementSystem/update.do":
			try {
				if (request.getSession().getAttribute("currentEmployee") == null) {

					LogThis.info("MasterDispatcher if currentEmployee == null");
					return "main.do";
				}
			} catch (Exception e) {
				return "main.do";
			}

			LogThis.info("MasterDispatcher update.do");
			return NavigationService.userUpdate(request);

		case "/EmployeeReimbursementSystem/submitReimb.do":
			try {
				if (request.getSession().getAttribute("currentEmployee") == null) {

					LogThis.info("MasterDispatcher if currentEmployee == null");
					return "main.do";
				}
			} catch (Exception e) {
				return "main.do";
			}

			LogThis.info("MasterDispatcher submitReimb.do");
			return ReimbursementService.newReimbursement(request);

		case "/EmployeeReimbursementSystem/approve.do":
			try {
				if (request.getSession().getAttribute("currentEmployee") == null) {

					LogThis.info("MasterDispatcher if currentEmployee == null");
					return "main.do";
				}
			} catch (Exception e) {
				return "main.do";
			}

			LogThis.info("MasterDispatcher approve.do");
			boolean approve = FinancialManagerService.resolveReimbursement(request, 2);
			if (approve) {
				return "pendingReimb.jsp";
			} else {
				return "404.do";
			}

		case "/EmployeeReimbursementSystem/deny.do":
			try {
				if (request.getSession().getAttribute("currentEmployee") == null) {

					LogThis.info("MasterDispatcher if currentEmployee == null");
					return "main.do";
				}
			} catch (Exception e) {
				return "main.do";
			}

			LogThis.info("MasterDispatcher deny.do");
			boolean deny = FinancialManagerService.resolveReimbursement(request, 3);
			if (deny) {
				return "pendingReimb.jsp";
			} else {
				return "404.do";
			}


		default:
			LogThis.info("The request URI was: " + request.getRequestURI());
			LogThis.info("Returning 404 from default");
			return "404.jsp";

		}

	}

}
