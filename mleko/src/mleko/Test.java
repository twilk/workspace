package mleko;

class X {
	String qq = "";
	
	X(String s) {
		qq = qq + " X" + s;
	}
	
	X(String s, String p) {
		qq = qq + " X" + s + p;
	}
	
	X() {
		qq = qq + " X";
	}
	
}
class Z extends Y {
	Z(String s) {
		qq = qq + " Z" + s;
	}
	
	protected void finalize() {
		System.out.println("Dziala");
	}
}

class Y extends X {
	Y(String s) {
		super(" Q", s);
		qq = qq + " Y" + s;
	}

	
	Y() {
		super(" A", " B");
		qq = qq + " Y";
	}
}

class DD {
	protected int a;
	
	public void wpiszA(int x) {
		a = x;
	}
}

class PP extends DD{
	public void wypiszA() {
		System.out.println(a);
	}
}


public class Test {
	public static void main(String[] args) {
		Z z = new Z(" Test");
		DD obiekt = new DD();
		obiekt.wpiszA(4);
		System.out.println(obiekt.a);
		System.out.println(z.qq);
		System.gc();
	}
	
	

}
