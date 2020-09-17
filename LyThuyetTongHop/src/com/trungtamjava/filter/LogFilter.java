package com.trungtamjava.filter;

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

@WebFilter(urlPatterns = { "/dang-ky", "/*" })
public class LogFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		
		System.out.println("Do filter");
		
		String ctxPath = req.getContextPath();
		System.out.println(ctxPath);
		
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		pw.println("Tu choi truy cap");
		// cho di tiep
		chain.doFilter(request, response);
		//resp.sendRedirect("/bao-tri");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
