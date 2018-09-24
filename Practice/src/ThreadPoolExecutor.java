import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExecutor {

	private final Queue<Runnable> queue;
	private final PoolWorker[] pool;
	private final int poolMaxSize;
	private final int queueMaxSize;
	private Boolean shutdown;
	private Boolean shutdownNow;

	public ThreadPoolExecutor(int nThreads, int queueMaxSize) {

		this.queue = new LinkedBlockingQueue<>();
		this.pool = new PoolWorker[nThreads];
		this.poolMaxSize = nThreads;
		this.queueMaxSize = queueMaxSize;
		this.shutdownNow = false;
		this.shutdown = false;
		for (int i = 0; i < poolMaxSize; i++) {
			pool[i] = new PoolWorker();
			pool[i].start();
		}

	}
	public void shutdown() {
		shutdown=true;
	}
	public List<Runnable> shutdownNow() {
		shutdownNow=true;
		for (int i = 0; i < poolMaxSize; i++) {
			pool[i].interrupt();
		}
		List<Runnable> opList=new ArrayList<>();
		while(!queue.isEmpty())
		opList.add(queue.poll());
		return opList;
	}

	public void execute(Runnable task) {
		if (!shutdown && !shutdownNow) {
			synchronized (queue) {
				if (queue.size() <= queueMaxSize) {
					queue.add(task);
					queue.notify();
				}
			}
		}
	}

	private class PoolWorker extends Thread {
		public void run() {
			Runnable task;
			while (true ) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = queue.remove();
					task.run();
					if(queue.isEmpty()&&shutdown) {
						break;
					}
				}
				
			}

		}

	}

}
