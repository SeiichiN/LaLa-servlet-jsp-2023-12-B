package servlet.create;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.dept.Dept;
import model.dept.GetDeptListLogic;
import model.dept.GetDeptNameByIdLogic;
import util.MyValidator;
import util.Tools;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		String dept_id = request.getParameter("dept_id");
		String dept_name = new GetDeptNameByIdLogic().execute(dept_id);
		Dept dept = new Dept(dept_id, dept_name);
		Employee emp = new Employee(id, name, age, dept);
		// empの入力値チェックが必要
		MyValidator validator = new MyValidator();
		List<String> errors = validator.check(emp);
		String url = null;
		if (errors.size() > 0) {
			// エラーがあれば createEmp.jsp(入力画面)に戻る
			request.setAttribute("errors", errors);
			url = "WEB-INF/jsp/create/createEmp.jsp";
			List<Dept> deptList = new GetDeptListLogic().execute();
			request.setAttribute("deptList", deptList);
		} else {
			url = "WEB-INF/jsp/create/createConfirm.jsp";
		}
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
