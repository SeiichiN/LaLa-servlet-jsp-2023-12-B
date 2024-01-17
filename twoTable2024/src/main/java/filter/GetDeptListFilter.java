package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import model.dept.Dept;
import model.dept.GetDeptListLogic;

// aside.jspで deptList を使うなら、すべてのURLでこのフィルターを
// 実行させる必要がある。"/*" が必要。
@WebFilter(urlPatterns = {"/list", "/create", "/update", "/deptList"})
public class GetDeptListFilter extends HttpFilter implements Filter {
       
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	List<Dept> deptList = new GetDeptListLogic().execute();
    	for (Dept d : deptList) {
    		System.out.println(d.getId() + ":" + d.getName());
    	}
    	request.setAttribute("deptList", deptList);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
