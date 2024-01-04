package main;

import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Mutter> mutterList = new ArrayList<>();
		
		new PostMutterThread("userA", mutterList).start();
		new PostMutterThread("userB", mutterList).start();
		new PostMutterThread("userC", mutterList).start();
		
		Thread.sleep(5000);
		System.out.println("size: " + mutterList.size());
		for (Mutter m : mutterList) {
			System.out.println(m.getUserName() + ":" + m.getText());
		}
	}

}
