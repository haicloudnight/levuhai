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

@WebServlet(urlPatterns = { "/admin/user/delete" })
public class DeleteUserController extends HttpServlet {

	// phuong thuc GET o client goi len
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		UserDao userDao = new UserDaoImpl();
		userDao.delete(Integer.parseInt(id));
		
		resp.sendRedirect(req.getContextPath() + "/admin/user/search");
	}
}
