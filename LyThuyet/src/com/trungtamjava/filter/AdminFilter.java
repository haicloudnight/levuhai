package com.trungtamjava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;
import com.trungtamjava.utils.UserRole;

@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			if (user.getRole().equals(UserRole.ROLE_ADMIN)) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect("/LyThuyetTongHop/login");
			}
		} else {
			resp.sendRedirect("/LyThuyetTongHop/login");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
