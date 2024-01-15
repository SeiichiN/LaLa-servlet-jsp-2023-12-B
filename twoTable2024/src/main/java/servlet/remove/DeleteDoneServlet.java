package servlet.remove;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteEmpLogic;

@WebServlet("/deleteDone")
public class DeleteDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DeleteEmpLogic logic = new DeleteEmpLogic();
		String msg = null;
		if (logic.execute(id)) {
			msg = "削除しました";
		} else {
			msg = "削除に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/remove/deleteDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
