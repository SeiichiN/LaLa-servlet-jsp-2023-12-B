package main;

import java.util.List;

import model.Mutter;
import model.PostMutterLogic;

public class PostMutterThread extends Thread {
	private String name;
	private PostMutterLogic logic;
	private List<Mutter> mutterList;
	
	public PostMutterThread(String name,
							PostMutterLogic logic,
							List<Mutter> mutterList) {
		this.name = name;
		this.logic = logic;
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
			logic.execute(mutter, mutterList);
			i++;
		}
		System.out.println(Thread.currentThread() + " end.");
	}
}
