package servlet.remove;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.GetDeptByIdLogic;

@WebServlet("/deleteDeptConfirm")
public class DeleteDeptConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_id = request.getParameter("dept_id").toUpperCase();
		GetDeptByIdLogic getDeptByIdLogic = new GetDeptByIdLogic();
		Dept dept = getDeptByIdLogic.execute(dept_id);
		String	url = "WEB-INF/jsp/remove/deleteDeptConfirm.jsp";
		request.setAttribute("dept", dept);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
