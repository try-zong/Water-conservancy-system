package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Entity.User;

@WebServlet(name = "loginServlet",urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L ;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String name = req.getParameter("user");
		String password = req.getParameter("pwd");
		String code = req.getParameter("code");
		@SuppressWarnings("unchecked")
		ArrayList<User> array=  (ArrayList<User>)this.
				getServletContext().getAttribute("User");
		Boolean f = false;
		HttpSession session = req.getSession(true);
		int i = 0;
		for(User us : array) {
			if(us.getUser().equals(name)){
				i = 1;
				if(us.getPassword().equals(password)){
					i = 2;
					if(session.getAttribute("rand").equals(code)){
						i = 3;
					    if(us.getState().equals("Õý³£")){
					    	session.setAttribute("user",name);
					    	f = true ;
					    	break;
					    }	
					}
				}
			}	
		}
		if(f == true) {
			resp.sendRedirect("main.jsp");
		}else if(i == 0){		
			resp.sendRedirect("login.jsp?error=nameError");
		}else if(i == 1){			
			resp.sendRedirect("login.jsp?error=pwdError");
		}else if(i == 2){
			resp.sendRedirect("login.jsp?error=securitycodeError");
		}else if(i == 3){
			resp.sendRedirect("login.jsp?error=stateError");
		}	
	}
}
