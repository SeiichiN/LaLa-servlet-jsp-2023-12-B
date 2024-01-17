package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.RegisterDeptLogic;

@WebServlet("/registerDept")
public class RegisterDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Dept dept = new Dept(id, name);
		RegisterDeptLogic logic = new RegisterDeptLogic();
		String msg = null;
		if (logic.execute(dept)) {
			msg = "登録できました";
		} else {
			msg = "登録に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/create/createDeptDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
