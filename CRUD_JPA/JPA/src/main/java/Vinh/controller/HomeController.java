package Vinh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Vinh.models.User;

@WebServlet(urlPatterns = {"/home","/admin/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession(false);
		if (!(session != null && session.getAttribute("account") != null)) {
			
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
	
		 String path = request.getServletPath();
		    if ("/home".equals(path)) {
		        request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
		    } else if ("/admin/home".equals(path)) {
		        request.getRequestDispatcher("/views/admin/home.jsp").forward(request, response);
		    } else {
		        response.sendError(HttpServletResponse.SC_NOT_FOUND);
		    }
	}

	
	

}
