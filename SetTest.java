import java.util.*;
import java.util.concurrent.*;

public class SetTest {

	private static void runTest(Set<Integer> s) {
		
		if(s instanceof HashSet)
			System.out.println("Testing HashSet: ");
		else if(s instanceof TreeSet)
			System.out.println("Testing TreeSet: ");
		else if(s instanceof CopyOnWriteArraySet)
			System.out.println("Testing CopyOnWriteArraySet: ");
		else if(s instanceof LinkedHashSet)
			System.out.println("Testing LinkedHashSet: ");
		else if(s instanceof ConcurrentSkipListSet)
			System.out.println("Testing ConcurrentSkipListSet: ");
		
		long llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			s.add(i);
		}
		long llEnd = System.currentTimeMillis();
		System.out.println("Total time for add(): " + (llEnd - llStart) + "ms");
			
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			s.contains(i);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for contains(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			s.remove(i);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for remove(): " + (llEnd - llStart) + "ms");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Set<Integer> hs = new HashSet<>();
		Set<Integer> ts = new TreeSet<>();
		Set<Integer> lhs = new LinkedHashSet<>();
		Set<Integer> csl = new ConcurrentSkipListSet<>();
		Set<Integer> cpy = new CopyOnWriteArraySet<>();
		
		runTest(hs);
		runTest(ts);
		runTest(lhs);
		runTest(csl);
		runTest(cpy);
		
	}
}
