package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Entity.WaterGate;


@WebServlet(name="GetGatesServlet",urlPatterns= {"/GetGatesServlet"})
public class GetGatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetGatesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		@SuppressWarnings("unchecked")
		ArrayList<WaterGate> array=  (ArrayList<WaterGate>)
				getServletContext().getAttribute("WaterGate");
			ObjectMapper mapper =new ObjectMapper();
			mapper.writeValue(resp.getWriter(),array);
		
	}

}
