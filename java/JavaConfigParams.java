
public class GAndroid {
    private static final int ANNOTATION= 0x00002000;
    private static final int ENUM      = 0x00004000;
    private static final int SYNTHETIC = 0x00001000;

    public boolean isAnnotation() {
        return true;//(getModifiers() & ANNOTATION) != 0;
    }

    public boolean isSynthetic() {
        return true;//(getModifiers() & SYNTHETIC) != 0;
    }

    public boolean isInitialized() {
        return true; //(flags & FLAG_INITIALIZED) == FLAG_INITIALIZED;
    }
    
    public static void main(String []args) {
    	checkAll(ANNOTATION | ENUM);
    }

	private static void checkAll(int i) {
		System.out.println(Integer.toOctalString( i ));
		if ((i & ANNOTATION) != 0) {
			System.out.println("ANNOTATION");
		}
		if ((i & SYNTHETIC) != 0) {
			System.out.println("SYNTHETIC");
		}
		if ((i & ENUM) != 0) {
			System.out.println("ENUM");
		}
	}
}
