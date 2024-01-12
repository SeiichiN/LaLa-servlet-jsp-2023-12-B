package servlet.create;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import util.MyValidator;
import util.Tools;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
		// empの入力値チェックが必要
		MyValidator validator = new MyValidator();
		List<String> errors = validator.check(emp);
		String url = null;
		if (errors.size() > 0) {
			// エラーがあれば createEmp.jsp(入力画面)に戻る
			request.setAttribute("errors", errors);
			url = "WEB-INF/jsp/create/createEmp.jsp";
		} else {
			url = "WEB-INF/jsp/create/createConfirm.jsp";
		}
		// エラーメッセージを送る。
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
