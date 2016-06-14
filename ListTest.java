import java.util.*;
import java.util.concurrent.*;

public class ListTest {
	private static void runTest(List<Integer> l) {
		
		if(l instanceof LinkedList)
			System.out.println("Testing LinkedList: ");
		else if(l instanceof CopyOnWriteArrayList)
			System.out.println("Testing CopyOnWriteArrayList: ");
		else if(l instanceof ArrayList)
			System.out.println("Testing ArrayList: ");
				
		long llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			l.add(i);
		}
		long llEnd = System.currentTimeMillis();
		System.out.println("Total time for add(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			l.get(i);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for get(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			l.contains(i);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for contains(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			l.remove(0);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for remove(): " + (llEnd - llStart) + "ms");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		List<Integer> ll = new LinkedList<>();
		List<Integer> al = new ArrayList<>();
		List<Integer> cpy = new CopyOnWriteArrayList<>();
		
		runTest(ll);
		runTest(al);
		runTest(cpy);
	}
}
