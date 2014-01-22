// Przyk�ad wskazywania klasy podrz�dnej 
// przez zmienn�  klasy nadrz�dnej 

// Klasa nadrz�dna
class A {
    int i, j;
    // ustawianie warto�ci
    void setA(int a, int b) {
	i = a;
	j = b;
    }
}

// Klasa podrz�dna
class B extends A {
    int k;
    // ustawianie warto�ci
    void setB(int a, int b, int c) {
	setA(a,b);
	k = c;
    }
}

class Dzidziczenie3 {
    public static void main(String args[]) {
	A obA = new A();
	B obB = new B();

	// ustawiamy warto�ci
	obA.setA(10,20);
	obB.setB(1,2,3);

	// wypisujemy zawarto��
	System.out.println("Zawarto�� A: ");
	System.out.println(" i = " + obA.i + " j = " + obA.j);
	System.out.println("Zawarto�� B: ");
	System.out.println(" i = " + obB.i + " j = " + obB.j + 
			   " k = " + obB.k + "\n");
	
        // obA bedzie wskazywa� na obB
	obA = obB;
	// wypisujemy zawarto��
	System.out.println("Zawarto�� A: ");
	System.out.println(" i = " + obA.i + " j = " + obA.j);
        // czy dost�pne b�dzie k
       	// System.out.println(" k = " + obA.k);
   }
}
