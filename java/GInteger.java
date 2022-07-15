class Paru {
	public int x =7;
	public void show() {
		System.out.println("Paru: " + this.x);
	}
}
class Basu extends Paru {
	public int x =70;
	public void show() {
		System.out.println("Basu: " + this.x);
	}
}
public class GInteger {
	public static void swap (int a, int b) {System.out.println("swap");		a = 5;		b = 6;	}
	public static void swap (Integer a, Integer b) {System.out.println("SWAP");		a = 7;		b = 8;	}
	
	public static void main (String []args) {

		Basu b1 = new Basu();
		((Paru) b1).show();

		int a = 1;
		int b = 2;
		Integer c = 3;
		Integer d = 4;
		swap(a, b);

		swap(c, d);
		
		System.out.println("a: " + a + ", b: "+ b + ", c: "+ c + ", d:" +d);
	}

}
