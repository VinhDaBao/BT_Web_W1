package Vinh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import Vinh.controller.Constant;
import java.io.File;
import java.io.IOException;

import Vinh.entity.Category;
import Vinh.service.ICategoryJPAService;
import Vinh.service.imp.CategoryJPAService;


@WebServlet("/admin/edit")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  
    maxFileSize = 1024 * 1024 * 10,    
    maxRequestSize = 1024 * 1024 * 50 
)
public class CategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ICategoryJPAService cateService = new CategoryJPAService();

    public CategoryEditController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Category category = cateService.findById(Integer.parseInt(id));
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/edit-category.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            Category category = cateService.findById(Integer.parseInt(id));
            if (category == null) {
                return;
            }

            category.setCate_name(name);

            Part filePart = request.getPart("icon");

            if (filePart != null && filePart.getSize() > 0) {
                String originalFileName = filePart.getSubmittedFileName();
                String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

                String fileName = System.currentTimeMillis() + "." + ext;

                File uploadDir = new File(Constant.DIR + "/category");
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String filePath = uploadDir.getAbsolutePath() + File.separator + fileName;

                filePart.write(filePath);

                category.setIcons("category/" + fileName);
            } else {
                
            }

            cateService.update(category);

            response.sendRedirect(request.getContextPath() + "/admin/list");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }
}
