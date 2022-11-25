package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.WaterGate;

@WebServlet("/DeleteGateServlet")
public class DeleteGateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteGateServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("getid");
		@SuppressWarnings("unchecked")
		ArrayList<WaterGate> array=  (ArrayList<WaterGate>)this.
				getServletContext().getAttribute("WaterGate");
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).getId().equals(id) ){
				 array.remove(i);
				 break;		
			}	
		}
		this.getServletContext().setAttribute("WaterGate", array);
		resp.sendRedirect("main.jsp");

	}

}
