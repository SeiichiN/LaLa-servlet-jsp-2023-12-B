package test;

import dao.EmployeesDAO;

public class IsExistsIdTest {

	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		String id = "EMP009";
		if (dao.isExistsId(id)) {
			System.out.println(id + "は存在する");
		} else {
			System.out.println(id + "は存在しない");
		}

	}

}
