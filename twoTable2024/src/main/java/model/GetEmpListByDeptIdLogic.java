package model;

import java.util.List;

import dao.EmployeesDAO;

public class GetEmpListByDeptIdLogic {
	public List<Employee> execute(String dept_id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findListByDeptId(dept_id);
	}
}
