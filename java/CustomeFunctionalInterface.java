import java.util.function.Function;

interface Square<T> {
	public T get(T t);
}

public class CustomeFunctionalInterface {
	public static void main(String [] args) {
		Function<Integer, Integer> getFuc = i -> i * i;
		Integer x= 5;
		System.out.println("Square of " + x + " is " + getFuc.apply(x));
		

		Square<Integer> getSquare = i -> i * i;
		x= 7;
		System.out.println("Square of " + x + " is " + getSquare.get(x));
	}
}
