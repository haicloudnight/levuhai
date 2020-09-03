package com.trungtamjava.servlet;

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
import com.trungtamjava.utils.UserRole;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			if (user.getRole().equals(UserRole.ROLE_ADMIN)) {
				resp.sendRedirect("/LyThuyetTongHop/admin/home");
			} else {
				resp.sendRedirect("/LyThuyetTongHop/member/home");
			}
		} else {
			resp.sendRedirect("/LyThuyetTongHop/login");
		}
	}
}
