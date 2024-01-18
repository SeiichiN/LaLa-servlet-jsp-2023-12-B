package servlet.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import util.MyValidator;

@WebServlet("/updateDeptConfirm")
public class UpdateDeptConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_id = request.getParameter("dept_id").toUpperCase();
		String dept_name = request.getParameter("dept_name");
		Dept dept = new Dept(dept_id, dept_name);
		// empの入力値チェックが必要
		MyValidator validator = new MyValidator();
		List<String> errors = validator.checkUpdate(dept);
		String url = null;
		if (errors.size() > 0) {
			// エラーがあれば createEmp.jsp(入力画面)に戻る
			request.setAttribute("errors", errors);
			url = "WEB-INF/jsp/update/updateDept.jsp";
		} else {
			url = "WEB-INF/jsp/update/updateDeptConfirm.jsp";
		}
		request.setAttribute("dept", dept);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
