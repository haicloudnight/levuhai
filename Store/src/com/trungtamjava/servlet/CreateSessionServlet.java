package com.trungtamjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class CreateSessionServlet extends HttpServlet{
  
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("name", "trungtamjava");
		PrintWriter pw = resp.getWriter();
		pw.println("Tao session " + session.getId());
		
		
	}
}
