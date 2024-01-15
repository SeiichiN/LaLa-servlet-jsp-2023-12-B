package servlet.remove;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmpByIdLogic;
import model.dept.Dept;
import model.dept.GetDeptListLogic;
import model.dept.GetDeptNameByIdLogic;
import util.MyValidator;
import util.Tools;

@WebServlet("/deleteConfirm")
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		GetEmpByIdLogic getEmpByIdLogic = new GetEmpByIdLogic();
		Employee emp = getEmpByIdLogic.execute(id);
		String	url = "WEB-INF/jsp/remove/deleteConfirm.jsp";
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
