package main;

import java.util.ArrayList;
import java.util.List;

import model.Mutter;
import model.PostMutterLogic;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Mutter> mutterList = new ArrayList<>();
		PostMutterLogic logic = new PostMutterLogic();
		
		new PostMutterThread("userA", logic, mutterList).start();
		new PostMutterThread("userB", logic, mutterList).start();
		new PostMutterThread("userC", logic, mutterList).start();
		
		Thread.sleep(5000);
		System.out.println("size: " + mutterList.size());
		for (Mutter m : mutterList) {
			System.out.println(m.getUserName() + ":" + m.getText());
		}
	}

}
