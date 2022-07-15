import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Consumer;

public class GHashCodeEquals {
	private String name;
	
	public GHashCodeEquals(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public static void main(String [] only) {
		GHashCodeEquals eh1 = new GHashCodeEquals("first");
		GHashCodeEquals eh2 = new GHashCodeEquals("first");
		GHashCodeEquals eh3 = new GHashCodeEquals("third");
		
		Consumer<String> sop = System.out::println;
		sop.accept("eh1:" + eh1.hashCode());
		sop.accept("eh2:" + eh2.hashCode());
		sop.accept("eh3:" + eh3.hashCode());

		sop.accept("eh1 == eh2:" + eh1.equals(eh2));
		sop.accept("eh2 == eh3:" + eh2.equals(eh3));
		sop.accept("eh3 == eh1:" + eh3.equals(eh1));
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(null, null);
		HashSet<Integer> s;
		sop.accept("map:" + map);
	}
}
