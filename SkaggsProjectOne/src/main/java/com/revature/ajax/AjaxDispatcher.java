package com.revature.ajax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.Employee;
import com.revature.dao.EmployeeService;
import com.revature.image.Image;
import com.revature.servlet.MasterDispatcher;

public class AjaxDispatcher {
	private AjaxDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
		switch(request.getRequestURI()) {
		case "/SkaggsProjectOne/getAllEmployees.ajax":
			return EmployeeService.getAllEmployees();
		case "/SkaggsProjectOne/getAllRequests.ajax":
			return EmployeeService.getAllRequests();
		case"/SkaggsProjectOne/getMyRequests.ajax":
			Employee e = (Employee) request.getSession().getAttribute("authorizedUser");
			return EmployeeService.getMyRequests(e);
		case"/SkaggsProjectOne/getRequests.ajax":
			Employee requested = (Employee) request.getSession().getAttribute("requestedUser");
			return EmployeeService.getMyRequests(requested);
		case "/SkaggsProjectOne/getImage.ajax":
			String reid = request.getParameter("request-id");
			System.out.println("requestId " + reid);
			System.out.println("current val 2" + MasterDispatcher.currentVal);
			ArrayList<Image> imageList = EmployeeService.getImage();	
			//String image64 = Base64.getEncoder().encodeToString(image);
			return imageList;
		default:
			return new String("Not implemented");
		}
	}

}
