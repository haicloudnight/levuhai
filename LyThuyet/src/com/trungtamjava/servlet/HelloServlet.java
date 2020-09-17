package com.trungtamjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	// phuong thuc GET o client goi len
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<h1>Hello Java Servlet</h1>");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("INIT----");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("DESTROY----");
	}

}
