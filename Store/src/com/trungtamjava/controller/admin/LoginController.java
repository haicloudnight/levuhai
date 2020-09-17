package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/login-admin") // ?errCode=100
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/login.jsp");
		dispathcer.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(password)) {
			System.out.println("Log in success");
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			// chuyen huong : server tra ve cho client mot trang web(duong dan) khac
			// req.getContextPath(): ten root path(ten project)
			if (user.getRole().equals("123")) {
				resp.sendRedirect(req.getContextPath() + "finalweb10/admin/home"); // respond : server tra ve
			}else {
				resp.sendRedirect(req.getContextPath() + "finalweb10/member/home");
			}
			
			System.out.println("Fail");
			resp.sendRedirect(req.getContextPath() + "/login-admin?errCode=100");
		}
	}
}
