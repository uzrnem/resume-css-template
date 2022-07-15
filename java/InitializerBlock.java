class Parent {
	Parent() {
		System.out.println("Parent Constructor");
	}
	{
		System.out.println("Parent Initializer");
	}
}

class InitializerBlock extends Parent {
	public InitializerBlock() {
		System.out.println("Vola Constructor");
	}
	{
		System.out.println("Vola Initializer");
	}
	
	public static void main(String [] args) {
		Parent v = new InitializerBlock();
	}
}