package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("index.jsp");
			// request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			String url = "WEB-INF/jsp/main.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		if (text != null && text.length() != 0) {
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			if (postMutterLogic.execute(mutter)) {
			} else {
				String errorMsg = "つぶやきを保存できません";
				request.setAttribute("errorMsg", errorMsg);
			}
		} else {
			String msg = "つぶやきが入力されていません";
			request.setAttribute("errorMsg", msg);
		}
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
