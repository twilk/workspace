// Przyk³ad wskazywania klasy podrzêdnej 
// przez zmienn±  klasy nadrzêdnej 

// Klasa nadrzêdna
class A {
    int i, j;
    // ustawianie warto¶ci
    void setA(int a, int b) {
	i = a;
	j = b;
    }
}

// Klasa podrzêdna
class B extends A {
    int k;
    // ustawianie warto¶ci
    void setB(int a, int b, int c) {
	setA(a,b);
	k = c;
    }
}

class Dzidziczenie3 {
    public static void main(String args[]) {
	A obA = new A();
	B obB = new B();

	// ustawiamy warto¶ci
	obA.setA(10,20);
	obB.setB(1,2,3);

	// wypisujemy zawarto¶æ
	System.out.println("Zawarto¶æ A: ");
	System.out.println(" i = " + obA.i + " j = " + obA.j);
	System.out.println("Zawarto¶æ B: ");
	System.out.println(" i = " + obB.i + " j = " + obB.j + 
			   " k = " + obB.k + "\n");
	
        // obA bedzie wskazywa³ na obB
	obA = obB;
	// wypisujemy zawarto¶æ
	System.out.println("Zawarto¶æ A: ");
	System.out.println(" i = " + obA.i + " j = " + obA.j);
        // czy dostêpne bêdzie k
       	// System.out.println(" k = " + obA.k);
   }
}
