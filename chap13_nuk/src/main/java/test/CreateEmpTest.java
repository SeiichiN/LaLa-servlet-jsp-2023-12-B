package test;

import dao.EmployeesDAO;
import model.Employee;

public class CreateEmpTest {

	public static void main(String[] args) {
		Employee emp = new Employee("EMP004", "浦島 太郎", 25);
		EmployeesDAO dao = new EmployeesDAO();
		if (dao.create(emp)) {
			System.out.println("登録成功");
		} else {
			System.out.println("登録失敗");
		}
	}

}
