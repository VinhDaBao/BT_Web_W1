package Vinh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Vinh.models.User;
import Vinh.service.imp.UserService;
import Vinh.service.imp.UserServiceImp;

/**
 * Servlet implementation class ForgotController
 */
@WebServlet("/resetpassword")
public class ForgotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String newpass = request.getParameter("newPassword");
		String alertMsg = "";
		UserService service = new UserServiceImp();
		User user = service.changepass(email,newpass);
		if (user != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("account", user);
		
			
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			alertMsg = "Tài khoản không tồn tại";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
