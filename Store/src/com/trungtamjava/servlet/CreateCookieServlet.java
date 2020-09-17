
package com.trungtamjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = "/cookie")
public class CreateCookieServlet extends HttpServletRequest {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("name", "trungtamjava");
		cookie1.setPath("/");
		cookie1.setMaxAge(1 * 60);

		resp.addCookie(cookie1);

	}

}