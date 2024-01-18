package servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.UpdateDeptLogic;

@WebServlet("/updateDeptDone")
public class UpdateDeptDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_id = request.getParameter("dept_id");
		String dept_name = request.getParameter("dept_name");
		Dept dept = new Dept(dept_id, dept_name);
		UpdateDeptLogic logic = new UpdateDeptLogic();
		String msg = null;
		if (logic.execute(dept)) {
			msg = "更新できました";
		} else {
			msg = "更新に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/update/updateDeptDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
