import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Factorials {
	public static Consumer<Integer> sop = System.out::println;
	
	public static void main(String []atrgs) {
		Scanner scan = new Scanner(System.in);
		Integer i = scan.nextInt();
		Integer fact = fact(i);
		sop.accept(fact);
	}
	
	private static Integer fact (Integer i ) {
		sop.accept(i);
		if (i <= 1) {
			return 1;
		}
		return i * fact(i -1);
	}
}
