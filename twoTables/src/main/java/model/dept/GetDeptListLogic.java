package model.dept;

import java.util.List;

import dao.DeptDAO;

public class GetDeptListLogic {
	public List<Dept> execute() {
		DeptDAO dao = new DeptDAO();
		return dao.findAll();
	}
}
