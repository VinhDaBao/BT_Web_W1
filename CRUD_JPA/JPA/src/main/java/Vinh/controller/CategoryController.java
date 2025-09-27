package Vinh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Vinh.models.Category;
import Vinh.service.imp.CategoryJPAService;
import Vinh.service.ICategoryJPAService;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet(urlPatterns = { "/admin/list" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICategoryJPAService cateService = new CategoryJPAService();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Vinh.entity.Category> cateList = cateService.findAll();
		request.setAttribute("cateList"
		, cateList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/list-category.jsp");
		dispatcher.forward(request, response);
		}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
