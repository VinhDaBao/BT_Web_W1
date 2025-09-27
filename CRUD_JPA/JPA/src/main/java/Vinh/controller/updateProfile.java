package Vinh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import Vinh.entity.NguoiDung;
import Vinh.service.imp.UserServiceJPAImp;
import Vinh.service.IUserServiceJPA;

/**
 * Servlet implementation class updateProfile
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/admin/updateProfile","/updateProfile"})

public class updateProfile extends HttpServlet {
	IUserServiceJPA service = new UserServiceJPAImp();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		System.out.print(email +"----"+ fullName);
		HttpSession session = request.getSession(false);
		
		NguoiDung user = (NguoiDung)session.getAttribute("account");
		String usernameString = user.getUsername();
		user = service.get(usernameString);
		user.setEmail(email);
		user.setFullname(fullName);
		try {

            Part filePart = request.getPart("avatar");
            if (filePart != null && filePart.getSize() > 0) {
                String originalFileName = filePart.getSubmittedFileName();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                String fileName = System.currentTimeMillis() + ext;

                File uploadDir = new File(Constant.ADIR );
                if (!uploadDir.exists()) uploadDir.mkdirs();

                filePart.write(uploadDir + File.separator + fileName);
                user.setAvatar(fileName);
                
            }
            service.updateProfile(user);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
		session.setAttribute("account", user);
		response.sendRedirect(request.getContextPath() + "/login");
		
	}

}
