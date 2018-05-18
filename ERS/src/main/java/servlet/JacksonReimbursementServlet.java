package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Reimbursement;
import model.ReimbursementImage;
import service.ReimbursementService;

public class JacksonReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JacksonReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		List<Reimbursement> reimbursements;
		
		if(username == null) 
			reimbursements = new ArrayList<>();
		else if(username.equals("all"))
			reimbursements = ReimbursementService.readReimbursements();
		else
			reimbursements = ReimbursementService.readReimbursements(username);
		
		ObjectMapper mapper = new ObjectMapper();
		List<ReimbursementImage> returnValue = reimbursements
				.stream()
				.map( reimbursement -> getImage(reimbursement) )
				.collect(Collectors.toList());
		
		response.getWriter().write(
				mapper.writeValueAsString(returnValue));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Reimbursement> reimbursements = ReimbursementService.readReimbursements();
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
		
		byte[] bytes;
		try {
			bytes = IOUtils.toByteArray(stream, 4751);
		} catch (Exception e) {
			Logger logger = Logger.getLogger(JacksonReimbursementServlet.class);
			logger.error(e.getMessage());
			bytes = null;
		}
		
		return new ReimbursementImage(reimbursementid, employee, manager, status, bytes, category);
	}
}
