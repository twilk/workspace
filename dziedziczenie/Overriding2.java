// Demonstracja nadpisania metody

class A {
    int i, j;
    
    A(int a, int b) {
	i = a;
	j = b;
    }
    // wy�wietl i oraz j
    void show() {
	System.out.println(" i = " + i + " j = " + j);
    }
    // reprezentacja napisowa
    public String toString() {
	return " i = " + i + " j = " + j;
    }
}

class B extends A {
    int k;
    
    B(int a, int b, int c) {
	super(a, b);
	k = c;
    }
    // wy�wietl k - metoda ta nadpisuje metod� show z A
    void show() {
	System.out.println(" k = " + k);
    }
    // reprezentacja napisowa
    // metoda ta tak�e nadpisuje metod� toString z A 
    // ale wywo�uje metod� z A przez super
    public String toString() {
	return super.toString() + " k = " + k;
    }
}
// klasa testuj�ca
class OverrideDemo2 {
    public static void main (String args[]) {
	B obB = new B(1, 2, 3);
	
	obB.show();  // wywo�anie show() z B
	// wywo�anie metody toString z B,
	// kt�ra wywo�uje toString z A
	System.out.println(obB.toString()); 
    }
}
