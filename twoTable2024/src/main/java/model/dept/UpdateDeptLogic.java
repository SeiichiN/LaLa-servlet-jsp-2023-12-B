package model.dept;

import dao.DeptDAO;

public class UpdateDeptLogic {
	public boolean execute(Dept dept) {
		DeptDAO dao = new DeptDAO();
		return dao.update(dept);
	}
}
