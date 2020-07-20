package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Category;
import service.CategoryService;
import service.CategoryServiceImpl;

@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryService service = new CategoryServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> cs = service.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(), cs);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
