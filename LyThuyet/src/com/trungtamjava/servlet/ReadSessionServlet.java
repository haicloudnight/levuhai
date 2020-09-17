package com.trungtamjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/read-session")
public class ReadSessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session  = req.getSession();
		
		String name = (String) session.getAttribute("name");
		
		PrintWriter pw = resp.getWriter();
		pw.print("Session: " + session.getId());
		pw.print("name: " + name);
	}
}
