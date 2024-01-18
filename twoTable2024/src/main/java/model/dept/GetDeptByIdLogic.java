package model.dept;

import dao.DeptDAO;

public class GetDeptByIdLogic {
	public Dept execute(String dept_id) {
		DeptDAO dao = new DeptDAO();
		return dao.findById(dept_id);
	}
}
