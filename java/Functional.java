import java.util.function.BiFunction;

@java.lang.FunctionalInterface
interface Functioning<T, R> {
    R appling(T t);
}
class Insan {
	public String getName (String name) {
		return name;
	}
}
class Functional {

	public static void main(String[] args) {
		
		Insan i = new Insan();
		method(i, "Nokia", Insan::getName);
	}

	private static<A, ID> void method(A i, ID string, BiFunction<A, ID, ID> bID) {
		System.out.println(bID.apply(i, string));
	}
}
