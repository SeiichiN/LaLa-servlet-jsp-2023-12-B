package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsExistsIdLogic;
import model.dept.IsExistsDeptIdLogic;

public class MyValidator {
	public List<String> check(Employee emp) {
		List<String> errors = new ArrayList<>();
		checkId(emp, errors);
		checkOther(emp, errors);
		return errors;
	}
	
	public List<String> checkUpdate(Employee emp) {
		List<String> errors = new ArrayList<>();
		checkOther(emp, errors);
		return errors;
	}
	
	private void checkId(Employee emp, List<String> errors) {
		if (emp.getId() == null || emp.getId().length() == 0) {
			errors.add("IDが未入力です");
		} else {
			if (!emp.getId().matches("^EMP[0-9]{3}$")) {
				errors.add("IDの形式が不正です");
			}
			IsExistsIdLogic isExistsIdLogic = new IsExistsIdLogic();
			if (isExistsIdLogic.execute(emp.getId())) {
				errors.add("そのIDは存在しています");
			}
		}
	}
	
	private void checkOther(Employee emp, List<String> errors) {
		if (emp.getName() == null || emp.getName().length() == 0) {
			errors.add("名前が未入力です");
		}
		else if (emp.getName().length() > 20) {
			errors.add("文字が長すぎます");
		}
		if (emp.getAge() < 20 || emp.getAge() > 80) {
			errors.add("年齢が不正です");
		}
		if (emp.getDept().getId() == null || emp.getDept().getId().length() == 0) {
			errors.add("部署IDが未入力です");
		}
		IsExistsDeptIdLogic isExistsDeptIdLogic = new IsExistsDeptIdLogic();
		if (!isExistsDeptIdLogic.execute(emp.getDept().getId())) {
			errors.add("そのIDは存在していません");
		}
	}
}
