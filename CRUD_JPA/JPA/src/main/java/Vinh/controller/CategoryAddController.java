package Vinh.controller;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig; 
import java.io.File;
import java.io.IOException;

import Vinh.entity.Category;
import Vinh.service.ICategoryJPAService;
import Vinh.service.imp.CategoryJPAService;

/**
 * Servlet implementation class CategoryAddController
 */
@MultipartConfig

@WebServlet(urlPatterns = { "/admin/add" })
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICategoryJPAService cateService = new CategoryJPAService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Đã vào doPost CategoryAddController");


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Category category = new Category();

        try {
            String name = request.getParameter("name");
            category.setCate_name(name);

            Part filePart = request.getPart("icon");
            if (filePart != null && filePart.getSize() > 0) {
                String originalFileName = filePart.getSubmittedFileName();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                String fileName = System.currentTimeMillis() + ext;

                File uploadDir = new File(Constant.DIR + "/category");
                if (!uploadDir.exists()) uploadDir.mkdirs();

                filePart.write(uploadDir + File.separator + fileName);

                category.setIcons("category/" + fileName);
                
            }

            cateService.insert(category);

            response.sendRedirect(request.getContextPath() + "/admin/list");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi khi thêm category: " + e.getMessage());
        }
    }

}
