package model;

import dao.EmployeesDAO;

public class IsExistsIdLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		if (dao.isExistsId(id)) {
			return true;
		} else {
			return false;
		}

	}
}
