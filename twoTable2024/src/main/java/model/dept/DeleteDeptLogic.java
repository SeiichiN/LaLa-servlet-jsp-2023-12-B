package model.dept;

import dao.DeptDAO;

public class DeleteDeptLogic {
	public boolean execute(String dept_id) {
		DeptDAO dao = new DeptDAO();
		return dao.remove(dept_id);
	}
}
