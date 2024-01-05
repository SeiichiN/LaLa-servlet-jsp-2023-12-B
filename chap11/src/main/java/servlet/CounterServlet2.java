package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CounterServlet2")
public class CounterServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer count;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		count = 0;
		System.out.println("init()が実行されました");
	}

	public void destroy() {
		System.out.println("destroy()が実行されました");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		count++;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html><head><meta charset=\"utf-8\" />");
		out.println("<title>訪問回数を表示</title>");
		out.println("</head><body>");
		out.println("<p>訪問回数: " + count + "</p>");
		out.println("<a href=\"CounterServlet2\">更新</a>");
		out.println("</body></html>");
	}

}
