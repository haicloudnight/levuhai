package com.trungtamjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;
import com.trungtamjava.utils.UserRole;

@WebServlet(urlPatterns = { "/dang-ky" })
public class RegisterUserController extends HttpServlet {

	// phuong thuc GET o client goi len
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// tao doi tuong user
		User user = new User();
		user.setName(name);
		user.setAge(Integer.parseInt(age));
		user.setRole(UserRole.ROLE_MEMBER);//mac dinh role member
		user.setLoginCounter(0);
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setGender(req.getParameter("gender"));
		user.setImage(req.getParameter("image"));

		UserDao userDao = new UserDaoImpl();
		userDao.add(user);

		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
