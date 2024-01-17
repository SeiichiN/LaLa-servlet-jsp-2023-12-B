package servlet.create;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.GetDeptListLogic;
import util.MyValidator;

@WebServlet("/createDeptConfirm")
public class CreateDeptConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		Dept dept = new Dept(id, name);
		// deptの入力値チェックが必要
		MyValidator validator = new MyValidator();
		List<String> errors = validator.check(dept);
		String url = null;
		if (errors.size() > 0) {
			// エラーがあれば createEmp.jsp(入力画面)に戻る
			request.setAttribute("errors", errors);
			url = "WEB-INF/jsp/create/createDept.jsp";
			List<Dept> deptList = new GetDeptListLogic().execute();
			request.setAttribute("deptList", deptList);
		} else {
			url = "WEB-INF/jsp/create/createDeptConfirm.jsp";
		}
		request.setAttribute("dept", dept);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
