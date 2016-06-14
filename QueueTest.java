import java.util.*;
import java.util.concurrent.*;

public class QueueTest {
	private static void runTest(Queue<Integer> q) {
		
		if(q instanceof PriorityQueue)
			System.out.println("Testing PriorityQueue: ");
		else if(q instanceof LinkedList)
			System.out.println("Testing LinkedList: ");
		else if(q instanceof ArrayDeque)
			System.out.println("Testing ArrayDeque: ");
		else if(q instanceof ConcurrentLinkedQueue)
			System.out.println("Testing ConcurrentLinkedQueue: ");
		else if(q instanceof ArrayBlockingQueue)
			System.out.println("Testing ArrayBlockingQueue: ");
		else if(q instanceof PriorityBlockingQueue)
			System.out.println("Testing PriorityBlockingQueue: ");
		else if(q instanceof SynchronousQueue)
			System.out.println("Testing SynchronousQueue: ");
		else if(q instanceof LinkedBlockingQueue)
			System.out.println("Testing LinkedBlockingQueue: ");
		
		
		long llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			q.offer(i);
		}
		long llEnd = System.currentTimeMillis();
		System.out.println("Total time for offer(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			q.peek();
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for peek(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			q.poll();
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for poll(): " + (llEnd - llStart) + "ms");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<>();
		Queue<Integer> ll = new LinkedList<>();
		Queue<Integer> ad = new ArrayDeque<>();
		Queue<Integer> clq = new ConcurrentLinkedQueue<>();
		Queue<Integer> abq = new ArrayBlockingQueue<>(99999);
		Queue<Integer> pbq = new PriorityBlockingQueue<>();
		Queue<Integer> sq = new SynchronousQueue<>();
		Queue<Integer> dq = new LinkedBlockingQueue<>();
		
		runTest(pq);
		runTest(ll);
		runTest(ad);
		runTest(clq);
		runTest(abq);
		runTest(pbq);
		runTest(sq);
		runTest(dq);
	}
}
