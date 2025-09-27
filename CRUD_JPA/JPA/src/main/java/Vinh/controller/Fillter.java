package Vinh.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

import Vinh.entity.NguoiDung;
import Vinh.service.IUserServiceJPA;
import Vinh.service.imp.UserServiceJPAImp;
@WebFilter("/admin/*")
public class Fillter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        IUserServiceJPA service = new UserServiceJPAImp();

        NguoiDung user = null;
        if (session != null && session.getAttribute("account") != null) {
            user = (NguoiDung) session.getAttribute("account");
        } else {
            // Check cookie (auto-login)
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        session = req.getSession(true);
                        session.setAttribute("username", cookie.getValue());
                        user = service.get(cookie.getValue());
                        session.setAttribute("account", user);
                        break;
                    }
                }
            }
        }

        if (user == null) {
        	res.sendRedirect(req.getContextPath() + "/login");            
        	return;
        }

        if ("1".equals(user.getRoleId())) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/home");
        }
    }
}