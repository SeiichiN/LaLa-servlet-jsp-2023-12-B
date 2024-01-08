package model;

import java.util.List;

public class PostMutterLogic {
	private static PostMutterLogic instance = new PostMutterLogic();
	private PostMutterLogic() {	}
	public static PostMutterLogic getInstance() {
		return instance;
	}
	public synchronized void execute(Mutter mutter, List<Mutter> mutterList) {
		mutterList.add(0, mutter);
	}
}
