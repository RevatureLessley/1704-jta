package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.Information;
import service.EmployeeService;
import service.InformationService;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		String username = request.getParameter("username");		
		String password = request.getParameter("password");
		String hash = EmployeeService.hash(username, password);
		
		Employee employee = EmployeeService.readEmployee(username);
		Information information = InformationService.readInformation(username);
		
		try {
			password = employee.getPassword();
		} catch(NullPointerException e) {
			password = "";
		}
		
		if(password.equals(hash) &&
				employee != null) {
			request.getSession().setAttribute("employee", employee);
			request.getSession().setAttribute("information", information);
			request.getRequestDispatcher("employee-home.do").forward(request, response);				
		} else {
			request.setAttribute("message", "bad login");
			request.getRequestDispatcher("employee-login.do").forward(request,response);
		}
	}
}
