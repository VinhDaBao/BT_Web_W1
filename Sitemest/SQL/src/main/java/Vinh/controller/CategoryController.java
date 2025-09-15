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
import Vinh.service.imp.CategoryService;
import Vinh.service.imp.CategoryServiceImp;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet(urlPatterns = { "/list" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServiceImp();
	
       
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
		Category temp = cateService.get(13);
		List<Category> cateList = cateService.getAll();
		request.setAttribute("cateList"
		, cateList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-category.jsp");
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
