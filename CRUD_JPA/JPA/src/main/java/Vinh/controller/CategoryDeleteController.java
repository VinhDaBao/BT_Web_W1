package Vinh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Vinh.service.ICategoryJPAService;
import Vinh.service.imp.CategoryJPAService;


/**
 * Servlet implementation class CategoryDeleteController
 */
@WebServlet(urlPatterns = { "/admin/delete" })
public class CategoryDeleteController extends HttpServlet {
	ICategoryJPAService cateService = new CategoryJPAService();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		cateService.delete(cateService.findById(Integer.parseInt(id)));
		response.sendRedirect(request.getContextPath() + "/admin/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
