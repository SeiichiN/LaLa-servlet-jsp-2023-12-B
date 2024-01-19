package servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.GetDeptByIdLogic;

@WebServlet("/updateDept")
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_id = request.getParameter("dept_id");
		String dept_name = request.getParameter("dept_name");
		Dept dept = null;
		if (dept_name == null) {
			dept = new GetDeptByIdLogic().execute(dept_id);
		} else {
			dept = new Dept(dept_id, dept_name);
		}
		request.setAttribute("dept", dept);
		String url = "WEB-INF/jsp/update/updateDept.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
