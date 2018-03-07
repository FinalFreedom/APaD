package counter;

import java.util.HashSet;

public class ThreadHashSet<T extends Thread> extends HashSet<T> implements ThreadSet<T>{

	@Override
	public void runSet() throws InterruptedException {
		// TODO Auto-generated method stub
		for(Thread thread: this) {
			thread.run();
		}
	}
}
