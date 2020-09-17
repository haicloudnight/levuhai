package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/login-admin") // ?errCode=100
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");

		if (code != null && code.equals("100")) {
			req.setAttribute("msg", "Tai khoan hoac mat khau sai");
		}
		RequestDispatcher dispathcer = req.getRequestDispatcher("/views/admin/login.jsp");
		dispathcer.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		System.out.println(username);
		System.out.println(pass);

		// tao session
		HttpSession session = req.getSession();
		System.out.println("session id : " + session.getId());

		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(pass)) {
			System.out.println("Log in success");
			// luu doi tuong vao session
			session.setAttribute("loginUser", user);
			// chuyen huong : server tra ve cho client mot trang web(duong dan) khac
			// req.getContextPath(): ten root path(ten project)
			resp.sendRedirect(req.getContextPath() + "/admin/user/search"); // respond : server tra ve
		} else {
			System.out.println("Fail");
			resp.sendRedirect(req.getContextPath() + "/login-admin?errCode=100");
		}
	}
}
