package com.trungtamjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = { "/admin/user/add" })
public class AddUserController extends HttpServlet {

	// phuong thuc GET o client goi len
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin/user/add-user.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao doi tuong user
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setAge(Integer.parseInt(req.getParameter("age")));
		user.setRole(req.getParameter("role"));// mac dinh role member
		user.setLoginCounter(0);
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setGender(req.getParameter("gender"));
		user.setImage(req.getParameter("image"));

		UserDao userDao = new UserDaoImpl();
		userDao.add(user);

		resp.sendRedirect(req.getContextPath() + "/admin/user/search");
	}
}
