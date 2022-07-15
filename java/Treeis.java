import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Treeis {
	public static void main(String [] args) {
		HashMap<Integer, String> hm;
		ConcurrentHashMap<Integer, String> in;
		ConcurrentLinkedQueue<String> s;
		
		String ;

		int a [] = {1, 4, 6, 2, 3, 5};
		for (int c= 0 ; c< a.length -1; c++ ) {
			for (int g= c+ 1; g < a.length; g++) {
				if (a[c] > a[g]) {
					a[c] = a[c] + a[g];
					a[g] = a[c] - a[g];
					a[c] = a[c] - a[g];
				}
			}
		}
		for ( int c= 0 ; c < a.length ; c++ ) {
			System.out.println(a[c]);
		}
	}
}
