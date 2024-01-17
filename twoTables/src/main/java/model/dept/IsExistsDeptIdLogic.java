package model.dept;

import dao.DeptDAO;

public class IsExistsDeptIdLogic {
	public boolean execute(String dept_id) {
		DeptDAO dao = new DeptDAO();
		return dao.isExistsId(dept_id);
	}
}	
