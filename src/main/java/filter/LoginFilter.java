package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("UTF-8");
		String req_uri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String uri =req_uri.substring(ctxPath.length());
		if(uri.contains("login.jsp") || uri.contains("loginServlet")||
				uri.contains("img") || uri.contains("css")|| 
				uri.contains("LogoutServlet") || uri.contains("GetGatesServlet")
				|| uri.contains("register.jsp") || uri.contains("RegisterUser")|| uri.contains("SecurityCode")) {
			chain.doFilter(req, resp);
		}else {
			if(null != session.getAttribute("user")) {
				chain.doFilter(req, resp);
			}else{
				resp.sendRedirect("login.jsp");
				}
			}
		
		}
	public void init(FilterConfig fConfig) throws ServletException{
	}
}