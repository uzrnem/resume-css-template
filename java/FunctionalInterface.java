import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.BiFunction;
import java.util.function.BiConsumer;

class FunctionalInterface {

	public static void main(String[] args) {

    // takes Double, returns String
    Function<Integer, String> addThen = (input) -> "Function Output : " + String.valueOf(input);
    Function<Integer, Integer> composeBefore = (input) -> input + 5;
    Function<Integer, Integer> func = n -> n * 2;
    String result = func.andThen(addThen).compose(composeBefore).apply(2);
    System.out.println(result);

		BiFunction<Integer, Float, Float> adder2 = (a, n) -> n * a;
		float result2 = adder2.andThen(x -> x-1).apply(10, 20.0f);
		System.out.println("BiFunction Output : " + result2);

		Consumer<String> sop = (s) -> System.out.println(s);
		sop.andThen((s) -> System.out.println("Add Then :" + s)).accept("This is Consumer class");

		BiConsumer<Integer, Integer> addPrint = (i, j) -> System.out.println("Addition is :" + (i + j));
		addPrint.andThen((i, j) -> System.out.println("Numbers are " + i + ", " + j)).accept(3, 4);


		Supplier<FunctionalInterface> a = FunctionalInterface::new;
		System.out.println("Constructor :"+a.get());

		Runnable r = () -> System.out.println("No Argument, No Return type");
		r.run();
	}
}
