package Vinh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Vinh.models.User;
import Vinh.service.imp.UserService;
import Vinh.service.imp.UserServiceImp;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		boolean isRememberMe = false;
		String remember = request.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String avatar = request.getParameter("avatar");
		String email = request.getParameter("email");
		User newuser = new User();
		newuser.setUserName(username);
		newuser.setPassWord(password);
		newuser.setFullName(fullname);
		newuser.setAvatar(avatar);
		newuser.setEmail(email);
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		UserService service = new UserServiceImp();
		User user = service.get(newuser.getUserName());
		if (user == null) {
			service.register(newuser);
			HttpSession session = request.getSession(true);
			session.setAttribute("account", newuser);
			if (isRememberMe) {
				saveRemeberMe(response, username);
			}
			
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			alertMsg = "Tài khoản đã tồn tại";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void saveRemeberMe(HttpServletResponse response, String
			username){
			 Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER,
			username);
			 cookie.setMaxAge(30*60);
			 response.addCookie(cookie);
			 }

}
