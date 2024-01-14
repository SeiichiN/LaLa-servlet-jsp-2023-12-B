package test;

import model.IsExistsIdLogic;

public class IsExistsIdLogicTest {

	public static void main(String[] args) {
		String id = "EMP007";
		IsExistsIdLogic logic = new IsExistsIdLogic();
		if (logic.execute(id)) {
			System.out.println("そのIDは存在しています");
		} else {
			System.out.println("そのIDは存在していません");
		}

	}

}
