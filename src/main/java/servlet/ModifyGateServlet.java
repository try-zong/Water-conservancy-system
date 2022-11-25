package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.WaterGate;


@WebServlet("/ModifyGateServlet")
public class ModifyGateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifyGateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("getid");
		WaterGate gate = new WaterGate(req.getParameter("name_gate"),id,
				req.getParameter("buildtime"),req.getParameter("responsible")
				,req.getParameter("longitude"),req.getParameter("dimensionality")
				,req.getParameter("intro"));
		
		@SuppressWarnings("unchecked")
		ArrayList<WaterGate> array=  (ArrayList<WaterGate>)
				getServletContext().getAttribute("WaterGate");
		Boolean f = false;
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).getId().equals(id) ){
				 f = true ;
				 array.remove(i);
				 array.add(i,gate);
				 break;		
			}	
		}
		
		if(f == true) {
			getServletContext().setAttribute("WaterGate", array);
			resp.sendRedirect("main.jsp");
		}
	}

}
