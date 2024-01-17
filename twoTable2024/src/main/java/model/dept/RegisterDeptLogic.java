package model.dept;

import dao.DeptDAO;

public class RegisterDeptLogic {
	public boolean execute(Dept dept) {
		DeptDAO dao = new DeptDAO();
		return dao.create(dept);
	}
}
