import java.util.*;
import java.util.concurrent.*;

public class MapTest {
	private static void runTest(Map<Integer, Integer> m) {

		if(m instanceof IdentityHashMap)
			System.out.println("Testing IdentityHashMap: ");
		else if(m instanceof WeakHashMap)
			System.out.println("Testing WeakHashMap: ");
		else if(m instanceof LinkedHashMap)
			System.out.println("Testing LinkedHashMap: ");
		else if(m instanceof TreeMap)
			System.out.println("Testing TreeMap: ");
		else if(m instanceof ConcurrentSkipListMap)
			System.out.println("Testing ConcurrentSkipListMap: ");
		else if(m instanceof ConcurrentHashMap)
			System.out.println("Testing ConcurrentHashMap: ");
		else if(m instanceof HashMap)
			System.out.println("Testing HashMap: ");
		
		
		long llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			m.put(i, i*2);
		}
		long llEnd = System.currentTimeMillis();
		System.out.println("Total time for add(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			m.get(i);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for get(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			m.containsKey(i);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for containsKey(): " + (llEnd - llStart) + "ms");
		
		
		llStart = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			m.remove(i);
		}
		llEnd = System.currentTimeMillis();
		System.out.println("Total time for remove(): " + (llEnd - llStart) + "ms");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Map<Integer, Integer> hm = new HashMap<>();
		Map<Integer, Integer> ihm = new IdentityHashMap<>();
		Map<Integer, Integer> whm = new WeakHashMap<>();
		Map<Integer, Integer> lhm = new LinkedHashMap<>();
		Map<Integer, Integer> tm = new TreeMap<>();
		Map<Integer, Integer> cslm = new ConcurrentSkipListMap<>();
		Map<Integer, Integer> chm = new ConcurrentHashMap<>();
		
		runTest(hm);
		runTest(ihm);
		runTest(whm);
		runTest(lhm);
		runTest(tm);
		runTest(cslm);
		runTest(chm);
	}
}
