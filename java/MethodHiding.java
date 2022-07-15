class Base {
	public void main() {
		System.out.println("Base.non-static");
	}
	public static void main1() {
		System.out.println("Base.static");
	}
}

class MethodHiding extends Base {
	public void main() {
		System.out.println("Vola.non-static");
	}
	public static void main1() {
		System.out.println("Vola.static");
	}
	
	public static void main(String [] args) {
		Base v = new MethodHiding();
		v.main();
		v.main1();
	}
}