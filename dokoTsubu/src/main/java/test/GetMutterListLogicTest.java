package test;

import java.util.List;

import model.GetMutterListLogic;
import model.Mutter;

public class GetMutterListLogicTest {

	public static void main(String[] args) {
		GetMutterListLogic logic = new GetMutterListLogic();
		List<Mutter> mutterList = logic.execute();
		for (Mutter m : mutterList) {
			System.out.print(m.getId() + " ");
			System.out.print(m.getUserName() + " ");
			System.out.println(m.getText());
		}
	}

}
