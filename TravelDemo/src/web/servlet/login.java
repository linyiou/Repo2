package web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.ResultInfo;
import domain.User;
import service.UserService;
import service.UserServiceImpl;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String,String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		UserService service = new UserServiceImpl();
		User u = service.login(user);
		ResultInfo info = new ResultInfo();
		
		if(u == null) {
			info.setFlag(false);
			info.setErrorMsg("Account or password error!");
			
		}
		if(u!=null && !"Y".equals(u.getStatus())) {
			info.setFlag(false);
			info.setErrorMsg("You have not activated. Please activate");
		}
		if(u!=null && "Y".equals(u.getStatus())) {
			request.getSession().setAttribute("user",u);//登录成功标记
			info.setFlag(true);
			
		}
		
		ObjectMapper mapper = new ObjectMapper();
	    response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(), info);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}


