class Basing {
	public void fun() {
		System.out.println("Base fun");
	}
}

class XPrivateMethad extends Basing {
	public void fun() {
		System.out.println("Derived fun");
	}
	public static void main(String[] args) {
		Basing obj = new XPrivateMethad();
		obj.fun();
	}
}