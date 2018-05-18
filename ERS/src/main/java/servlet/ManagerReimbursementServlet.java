package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Manager;
import model.Reimbursement;
import service.ReimbursementService;

@MultipartConfig
public class ManagerReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		int reimbursementid = Integer.parseInt(request.getParameter("id"));
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		String managername = manager.getUsername();
		
		ReimbursementService.updateReimbursement(reimbursementid, status, managername);
		List<Reimbursement> reimbursements = ReimbursementService.readReimbursements();
		request.getSession().setAttribute("reimbursements", reimbursements);
		request.getRequestDispatcher("manager-update-reimbursement.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		if(manager == null) {
			request.setAttribute("message", "lost session; relogin");
			request.getRequestDispatcher("manager-login.do").forward(request, response);
		}
		String inUsername = manager.getUsername();
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
		List<Reimbursement> reimbursements = ReimbursementService.readReimbursements(inUsername);
		request.getSession().setAttribute("reimbursements", reimbursements);
		
		request.getRequestDispatcher("manager-update-reimbursement.do").forward(request, response);
	}
}
