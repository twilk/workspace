// Przyk�ad dziedziczenia ze zmiennymi prywatnymi
// Zmienne prywatne nie s� dost�pne dla klas podrz�dnych

// Klasa nadrz�dna
class A {
    int i; 
    private int j; // tym razem j jest prywatna
    // ustawianie warto�ci
    void setA(int a, int b) {
	i = a;
	j = b;
    }
    // poka� zawarto�� klasy
    String zawartoscA() {
	return ("\ti = " + i + "\tj = " +j);
    } 
    // suma zawarto�ci
    int sumaA() {
	return i + j;
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
    // poka� zawarto�� klasy
    String zawartoscB() {
	return zawartoscA() + "\tk = " + k;
    }
    // niepoprawna definicja metody
    // String zawartoscB() {
    //	return zawartoscA() + "\tk = " + k;
    // }
    // suma zawarto�ci
    int sumaB() {
	return sumaA() + k;
    }
    // niepoprawna definicja metody
    // int sumaB() {
    //    return i + j + k;
    // }
}

class Dzidziczenie2 {
    public static void main(String args[]) {
	A obA = new A();
	B obB = new B();

	// ustawiamy warto�ci
	obA.setA(10,20);
	obB.setB(1,2,3);
	// wypisujemy zawarto��
	System.out.println("Zawarto�� A: " + obA.zawartoscA());
	System.out.println("Zawarto�� B: " + obB.zawartoscB() + "\n");
	
 	// wypisujemy sumy
	System.out.println("Suma A: " + obA.sumaA());
	System.out.println("Suma B: " + obB.sumaB() + "\n");
   }
}
