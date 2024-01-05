package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Human;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Human human = new Human("綾部", 22);
		request.setAttribute("human", human);
		
		Human human2 = new Human("菅原", 34);
		HttpSession session = request.getSession();
		session.setAttribute("human", human2);
		
		String url = "WEB-INF/jsp/hello.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
