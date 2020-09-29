package com.trungtamjava.filter;

import java.io.IOException;

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

import com.trungtamjava.model.User;




@WebFilter(urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletResponse resp = ( HttpServletResponse) response;
		    HttpServletRequest req = (HttpServletRequest) request;
		    HttpSession session = req.getSession();
		    if(session.getAttribute("user") !=null) {
		    	User user = (User) session.getAttribute("user");
		    if (user.getRole().equals("UserRole.ROLE_ADMIN")) {
				resp.sendRedirect("/Store/admin/home"); // respond : server tra ve
			}else {
				resp.sendRedirect("/Store/admin/home");
			}
		    resp.sendRedirect("/Store/member/home");
	}}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
