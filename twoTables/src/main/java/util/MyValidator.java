package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsExistsIdLogic;
import model.dept.IsExistsDeptIdLogic;

public class MyValidator {
	// 新規作成時
	public List<String> check(Employee emp) {
		List<String> errors = new ArrayList<>();
		checkId(emp, errors);
		checkOther(emp, errors);
		return errors;
	}
	
	// 更新時
	public List<String> checkUpdate(Employee emp) {
		List<String> errors = new ArrayList<>();
		checkOther(emp, errors);
		return errors;
	}
	
	private void checkId(Employee emp, List<String> errors) {
		if (emp.getId() == null || emp.getId().length() == 0) {
			errors.add("IDが未入力です");
		}
		if (!emp.getId().matches("^EMP[0-9]{3}$")) {
			errors.add("IDの形式が不正です");
		}
		IsExistsIdLogic isExistsIdLogic = new IsExistsIdLogic();
		if (isExistsIdLogic.execute(emp.getId())) {
			errors.add("そのIDは存在しています");
		}		
	}
	
	private void checkOther(Employee emp, List<String> errors) {
		if (emp.getName() == null || emp.getName().length() == 0) {
			errors.add("名前が未入力です");
		}
		if (emp.getName().length() > 20) {
			errors.add("文字が長すぎます");
		}
		if (emp.getAge() < 20 || emp.getAge() > 80) {
			errors.add("年齢が不正です");
		}
		// dept_idのチェック
		IsExistsDeptIdLogic deptLogic = new IsExistsDeptIdLogic();
		if (!deptLogic.execute(emp.getDept().getId())) {
			errors.add("存在していない部署です");
		}		
	}
} // class end
