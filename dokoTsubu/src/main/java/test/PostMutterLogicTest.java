package test;

import model.Mutter;
import model.PostMutterLogic;

public class PostMutterLogicTest {

	public static void main(String[] args) {
		Mutter mutter = new Mutter("湊", "1日パチンコかな");
		PostMutterLogic logic = new PostMutterLogic();
		if (logic.execute(mutter)) {
			System.out.println("書き込み成功");
		} else {
			System.out.println("書き込み失敗");
		}

	}

}
