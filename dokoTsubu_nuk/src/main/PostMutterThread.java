package main;

import java.util.List;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

public class PostMutterThread extends Thread {
	private String name;
	private List<Mutter> mutterList;
	
	public PostMutterThread(String name, List<Mutter> mutterList) {
		this.name = name;
		this.mutterList = mutterList;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 10) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
			Mutter mutter = new Mutter(name, "じゅげむ" + i);
			// PostMutterLogic logic = new PostMutterLogic();
			PostMutterLogic.execute(mutter, mutterList);
			i++;
		}
		System.out.println(Thread.currentThread() + " end.");
	}
}
