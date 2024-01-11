package servlet.create;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import util.Tools;
import util.Validator;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
		// empの入力値チェックが必要
		// エラーがあれば createEmp.jsp にもどる。
		// エラーメッセージを送る。
		Validator validator = new Validator();
		Map<String, String> errorList = validator.ckeck(emp);
		String url = null;
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			url = "WEB-INF/jsp/create/createEmp.jsp";
		} else {
			url = "WEB-INF/jsp/create/createConfirm.jsp";
		}
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
