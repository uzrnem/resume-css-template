/*
 * Volatile
 */
class XVolatile {
	public volatile Integer a= 10;
	public Integer b= 10;
	
	public static void main(String [] args) {
		XVolatile v = new XVolatile();
		System.out.println("a: " + v.a);
		printA(v);
		System.out.println(v.a);

		System.out.println("a: " + v.b);
		printB(v);
		System.out.println(v.b);
	}

	public static void printA(XVolatile j) {
		j.a = 20;
		System.out.println(j.a);
	}

	public static void printB(XVolatile j) {
		j.b = 20;
		System.out.println(j.b);
	}
}