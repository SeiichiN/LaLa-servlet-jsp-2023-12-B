package util;

import java.util.HashMap;
import java.util.Map;

import model.Employee;
import model.IsExistsIdLogic;

public class Validator {
	public Map<String, String> ckeck(Employee emp) {
		// List<String> errors = new ArrayList<>();
		Map<String, String> errors = new HashMap<>();
		
		if (emp.getId() == null || emp.getId().length() == 0) {
			errors.put("id", "IDが未入力です");
		}
		if (!emp.getId().matches("^EMP[0-9]{3}$")) {
			System.out.println(emp.getId());
			errors.put("id", "IDの形式が不正です");
		}
		IsExistsIdLogic isExistsIdLogic = new IsExistsIdLogic();
		if (isExistsIdLogic.execute(emp.getId())) {
			errors.put("id", "そのIDはすでに使われています");
		}
		if (emp.getName() == null || emp.getName().length() == 0) {
			errors.put("name", "名前が未入力です");
		}
		if (emp.getName().length() > 20) {
			errors.put("name", "名前の文字数が多すぎます");
		}
		if (emp.getAge() < 20 || emp.getAge() > 80) {
			errors.put("age", "年齢が不正です");
		}
		return errors;
	}
}
