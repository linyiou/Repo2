package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

@WebServlet("/activeUserServlet")
public class activeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String code = request.getParameter("code");
		if(code!=null) {
			UserService service = new UserServiceImpl();
			boolean flag = service.active(code);
			
			String msg = null;
			if(flag) {
				msg="����ɹ�����<a href = 'login.html'>��¼</a>";
				
			}else {
				msg="����ʧ�ܣ�����ϵ����Ա!";
			}
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(msg);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
