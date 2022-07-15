import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Consumer;

@Retention(RetentionPolicy.RUNTIME) // for runtime something
@Target(ElementType.TYPE) //for class
@interface SmartPhone {
	String os() default "Symbian";
	int version() default 9;
}

@SmartPhone (os = "Android")
class Nokia {
	
}

@SmartPhone (os = "iPhone", version= 13)
class Apple {
	
}
public class GAnnotation {
	public static void main (String [] args) {
		Nokia n = new Nokia();
		Class klas = n.getClass();
		Annotation as = klas.getAnnotation(SmartPhone.class);
		SmartPhone s = (SmartPhone) as;
		Consumer<String> sop = System.out::println;
		sop.accept("Operating System is " + s.os());
		sop.accept("and Version is " + s.version());
	}
}
