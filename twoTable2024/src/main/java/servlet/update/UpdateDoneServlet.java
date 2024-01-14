package servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.UpdateEmpLogic;
import model.dept.Dept;
import util.Tools;

@WebServlet("/updateDone")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		String dept_id = request.getParameter("dept_id");
		Dept dept = new Dept(dept_id, null);
		Employee emp = new Employee(id, name, age, dept);
		UpdateEmpLogic logic = new UpdateEmpLogic();
		String msg = null;
		if (logic.execute(emp)) {
			msg = "更新できました";
		} else {
			msg = "更新に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/update/updateDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
