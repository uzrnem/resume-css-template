import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product extends Object {
	private Float price;

	Product( Float price) {
		this.price = price;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
public class GStreamApi {
	/*
	boolean anyMatch(Predicate<? super T> predicate)
	<R,A> R collect(Collector<? super T,A,R> collector)
	long count()
	Stream<T> distinct()
	Stream<T> filter(Predicate<? super T> predicate)
	void forEach(Consumer<? super T> action)
	<R> Stream<R> map(Function<? super T,? extends R> mapper)
	IntStream mapToInt(ToIntFunction<? super T> mapper)
	Optional<T> max(Comparator<? super T> comparator)
	Optional<T> min(Comparator<? super T> comparator)
	Optional<T> reduce(BinaryOperator<T> accumulator)
	Stream<T> sorted()
	Stream<T> sorted(Comparator<? super T> comparator)
	Object[] toArray()
	<A> A[] toArray(IntFunction<A[]> generator)
	 */


	public static void main(String [] params) {
		
		List<Product> productsList = new ArrayList<Product>();
		productsList.add(new Product((float) 5000));
		productsList.add(new Product((float) 50000));
		productsList.add(new Product((float) 500000));
		
        List<Float> productPriceList2 =productsList.stream()  
                .filter(p -> p.getPrice() > 30000)// filtering data  
                .map(p->p.getPrice())        // fetching price  
                .collect(Collectors.toList()); // collecting as list  
        System.out.println("52"+productPriceList2);

        Stream.iterate(1, element->element+1)  
	        .filter(element->{ //System.out.print("55:"+element); 
	        	return (element%5)==0;})  
	        .limit(5)  
	        .forEach(System.out::println);  

        float totalPrice2 = productsList.stream()  
	        .map(product->product.getPrice())  
	        .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class  
        System.out.println("62"+totalPrice2);
        
        Product productB = productsList.stream()  
	        .max((product1, product2)-> product1.getPrice() < product2.getPrice() ? 1: -1)
	        .get();  
        System.out.println("67"+productB);
		long count = productsList.stream()
	        .count();  
        System.out.println("70"+count);
	}
}

/*
    Stream<T> filter(Predicate<? super T> predicate);

    <R> Stream<R> map(Function<? super T, ? extends R> mapper);

    IntStream mapToInt(ToIntFunction<? super T> mapper);

    Stream<T> distinct();
    Stream<T> sorted();
    Stream<T> sorted(Comparator<? super T> comparator);
    Stream<T> peek(Consumer<? super T> action);
    Stream<T> limit(long maxSize);
    Stream<T> skip(long n);

    void forEach(Consumer<? super T> action);
    void forEachOrdered(Consumer<? super T> action);

    Object[] toArray();

    <A> A[] toArray(IntFunction<A[]> generator);

    T reduce(T identity, BinaryOperator<T> accumulator);

    Optional<T> reduce(BinaryOperator<T> accumulator);

    <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
    <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);

    <R, A> R collect(Collector<? super T, A, R> collector);

    Optional<T> min(Comparator<? super T> comparator);
    Optional<T> max(Comparator<? super T> comparator);

    long count();

    boolean anyMatch(Predicate<? super T> predicate); 
    boolean allMatch(Predicate<? super T> predicate);
    boolean noneMatch(Predicate<? super T> predicate);
    Optional<T> findFirst();
    Optional<T> findAny();

    public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f);
    public static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next);
    
    
    
 * boolean anyMatch(Predicate<? super T> predicate)
<R,A> R collect(Collector<? super T,A,R> collector)
long count()
Stream<T> distinct()
Stream<T> filter(Predicate<? super T> predicate)
void forEach(Consumer<? super T> action)
<R> Stream<R> map(Function<? super T,? extends R> mapper)
IntStream mapToInt(ToIntFunction<? super T> mapper)
Optional<T> max(Comparator<? super T> comparator)
Optional<T> min(Comparator<? super T> comparator)
Optional<T> reduce(BinaryOperator<T> accumulator)
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class  

        Stream.iterate(1, element->element+1)  
                                     .filter(p -> p.price > 30000)// filtering data  
                                     .map(p->p.price)        // fetching price  
        .limit(5)  
Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator)

Object[] toArray()
<A> A[] toArray(IntFunction<A[]> generator)

        .forEach(System.out::println);  

                    .count();  
 */


