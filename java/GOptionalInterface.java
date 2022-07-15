import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

class Person {
	private String username;
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;		
	}
}
class Bitwise <T, R> {
	private T t;
	private Function<T, R> f;

	public Bitwise(T t, Function<T, R> f) {
		this.t = t;
		this.f = f;
	}

	public static <T, R> Bitwise<T, R> get(T t, Function<T, R> f) {
		return new Bitwise<T, R>(t, f);
	}

	@SuppressWarnings("unchecked")
	public <U, V> V orElse(U o) {
		if (t != null) {
			return (V) f.apply(t);
		} else {
			return (V) o;
		}
	}
    public T orElseGet(Supplier<? extends T> supplier) {
        return value != null ? value : supplier.get();
    }

    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the non-{@code null} value described by this {@code Optional}
     * @throws NoSuchElementException if no value is present
     * @since 10
     */
    public T orElseThrow() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    /**
     * If a value is present, returns the value, otherwise throws an exception
     * produced by the exception supplying function.
     *
     * @apiNote
     * A method reference to the exception constructor with an empty argument
     * list can be used as the supplier. For example,
     * {@code IllegalStateException::new}
     *
     * @param <X> Type of the exception to be thrown
     * @param exceptionSupplier the supplying function that produces an
     *        exception to be thrown
     * @return the value, if present
     * @throws X if no value is present
     * @throws NullPointerException if no value is present and the exception
     *          supplying function is {@code null}
     */
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }
}
public class GOptionalInterface extends Object {
	public static void main (String [] args) {
        Optional<String> checkNull = Optional.ofNullable("NuLLiNg");  
        if(checkNull.isPresent()){  // check for value is present or not  
            String lowercaseString = checkNull.get().toLowerCase();  
            System.out.println(checkNull.get() + ":" + lowercaseString);  
        } else {
            System.out.println("nulling321312");  
        }
        Optional<String> value = Optional.ofNullable(null);  
        value.ifPresentOrElse(System.out::println, ()-> {System.out.println("NOTHING THERE");});
        System.out.println("Filtered value: "+value.filter((s)->s.equals("Abc")).orElse("NOT ABC"));
        
        Person person = new Person();
        String username = (String) Bitwise.get(person, Person::getUsername).orElse(null);
        System.out.println("Filtered value: "+username);
        person.setUsername("bhagyesh");
        username = (String) Bitwise.get(person, Person::getUsername).orElse(null);
        System.out.println("Filtered value: "+username);
	}

}
