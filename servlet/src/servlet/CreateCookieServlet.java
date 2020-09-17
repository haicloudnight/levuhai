package servlet;

import java.io.IOException;

public class CreateCookieServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/user/addUser.jsp");
		dispatcher.forward(req, resp);
	}
	

}
