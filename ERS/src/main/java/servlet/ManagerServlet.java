package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.Manager;
import model.Reimbursement;
import service.EmployeeService;
import service.ManagerService;
import service.ReimbursementService;

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hash = ManagerService.hash(username, password);
		Manager manager = ManagerService.readManager(username);
		
		try {
			password = manager.getPassword();	
		} catch(NullPointerException e) {
			password = "";			
		}
		
		if(password.equals(hash) && 
				manager != null) {
			request.getSession().setAttribute("manager", manager);
			request.getRequestDispatcher("manager-home.do").forward(request, response);
		} else {
			request.getSession().setAttribute("message", "user not found");
			request.getRequestDispatcher("managerlogin.jsp").forward(request, response);
		}
	}

}
