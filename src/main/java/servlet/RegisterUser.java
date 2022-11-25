package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import Entity.WaterGate;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		int jobNumber = Integer.parseInt(req.getParameter("jobNumber"));
		User user= new User(name,jobNumber,req.getParameter("password"),
				req.getParameter("role"),"Õý³£");
		
		@SuppressWarnings("unchecked")
		ArrayList<User> array_user = (ArrayList<User>)
				getServletContext().getAttribute("User");
		Boolean f = false;
		for(int i = 0; i < array_user.size(); i++) {
			if(array_user.get(i).getUser().equals(name) ){
				 f = true ;
				 break;		
			}	
		}
		
		if(f == true) {
			resp.sendRedirect("register.jsp");
		}else {
			array_user.add(user);
			getServletContext().setAttribute("User", array_user);
			resp.sendRedirect("login.jsp");
		}
	}

}
