package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.dept.Dept;
import model.dept.GetDeptNameByIdLogic;
import util.Tools;

@WebServlet("/create")
public class CreateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		String dept_id = request.getParameter("dept_id");
		String dept_name = new GetDeptNameByIdLogic().execute(dept_id);
		Dept dept = new Dept(dept_id, dept_name);
		Employee emp = new Employee(id, name, age, dept);
		request.setAttribute("emp", emp);
		String url = "WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
