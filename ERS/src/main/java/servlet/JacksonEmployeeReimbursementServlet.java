package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Employee;
import model.Reimbursement;
import model.ReimbursementImage;
import service.ReimbursementService;

public class JacksonEmployeeReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JacksonEmployeeReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("message", "lost session; relogin"); 
			request.getRequestDispatcher("employee-login.do").forward(request, response);
		}
			
		
		String username = employee.getUsername();
		
		ObjectMapper mapper = new ObjectMapper();
		List<Reimbursement> reimbursements = ReimbursementService.readReimbursements(username);
		
		List<ReimbursementImage> returnValue = reimbursements
				.stream()
				.map( reimbursement -> getImage(reimbursement) )
				.collect(Collectors.toList());
		
		response.getWriter().write(
				mapper.writeValueAsString(returnValue));
	}
	
	private ReimbursementImage getImage(Reimbursement reimbursement) {
		int reimbursementid = reimbursement.getReimbursementid();
		String employee = reimbursement.getEmployee();
		String manager = reimbursement.getManager();
		String status = reimbursement.getStatus();
		InputStream stream = reimbursement.getImage();
		String category = reimbursement.getCategory();
		
		byte[] bytes = null;
		try {
			bytes = IOUtils.toByteArray(stream);
		} catch (IOException e) {
			Logger logger = Logger.getLogger(JacksonEmployeeReimbursementServlet.class);
			logger.error(e);
		} 
		System.out.println("bytes " + bytes);
		
		return new ReimbursementImage(reimbursementid, employee, manager, status, bytes, category);
	}
}
