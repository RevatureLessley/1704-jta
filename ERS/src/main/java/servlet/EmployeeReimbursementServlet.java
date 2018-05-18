package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Employee;
import service.ReimbursementService;

@MultipartConfig
public class EmployeeReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeReimbursementServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		if(employee == null) {
			request.setAttribute("message", "lost session; relogin");
			request.getRequestDispatcher("employee-login.do").forward(request, response);
		}
			
		
		String inUsername = employee.getUsername();
		
		String inCategory = request.getParameter("category");
		if(inCategory == null)
			inCategory = "other";
		
		Part part = request.getPart("image");
		InputStream image = null;
		if(part != null) {
			System.out.println(part.getName());
			System.out.println(part.getSize());
			System.out.println(part.getContentType());
			System.out.println(part);
			image = part.getInputStream();
		}
		else if(part == null) {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			image = classloader.getResourceAsStream("noimage.png");				
		}
		
		ReimbursementService.createReimbursement(inUsername, "pending", image, inCategory);
		image.close();
		
		request.getRequestDispatcher("employee-read-reimbursement.do").forward(request, response);
	}
}
