package com.trungtamjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/read-cookie")
public class ReadCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();
		Cookie[] cookies = (Cookie[]) req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				printWriter.println(cookie.getName() + ": " + cookie.getValue());
			}
		}
	}
}
