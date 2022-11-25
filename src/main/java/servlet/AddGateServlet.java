package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.WaterGate;

@WebServlet("/AddGateServlet")
public class AddGateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddGateServlet() {
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
		String name_gate = req.getParameter("name_gate");
		String buildtime = req.getParameter("buildtime");
		String responsible = req.getParameter("responsible");
		@SuppressWarnings("unchecked")
		ArrayList<WaterGate> array=  (ArrayList<WaterGate>)
				getServletContext().getAttribute("WaterGate");
		Boolean f = false;
		for(WaterGate us : array) {
			if(us.getId().equals(id) ){
				 f = true ;
				 break;		
			}	
		}
		if(f == true) {
			RequestDispatcher dis = req.getRequestDispatcher("addGate.jsp");
			dis.forward(req, resp);
		}else if(null == name_gate || null == buildtime || null ==responsible) {
			RequestDispatcher dis = req.getRequestDispatcher("addGate.jsp");
			dis.forward(req, resp);
		}else {
			WaterGate gate = new WaterGate(req.getParameter("name_gate"),id,
					req.getParameter("buildtime"),req.getParameter("responsible")
					,req.getParameter("longitude"),req.getParameter("dimensionality")
					,req.getParameter("intro"));
			array.add(gate);
			this.getServletContext().setAttribute("WaterGate", array);
			resp.sendRedirect("main.jsp");
		}
	}

}
