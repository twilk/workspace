// Demonstracja nadpisania metody

class A {
    int i, j;
    
    A(int a, int b) {
	i = a;
	j = b;
    }
    // wy¶wietl i oraz j
    void show() {
	System.out.println(" i = " + i + " j = " + j);
    }
}

class B extends A {
    int k;
    
    B(int a, int b, int c) {
	super(a, b);
	k = c;
    }
    // wy¶wietl k - metoda ta nadpisuje metodê show z A
    void show() {
	System.out.println("k = " + k);
    }
}
// klasa testuj±ca
class OverrideDemo1 {
    public static void main (String args[]) {
	B obB = new B(1, 2, 3);
	
	obB.show(); // wywo³anie show() z B
    }
}
