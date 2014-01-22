// Przyk³ad dynamicznego wi±zania metod

class A {
    void callMe() {
	System.out.println("Metoda klasy A");
    }
}

class B extends A {
    void callMe() {
	System.out.println("Metoda klasy B");
    }
}

class C extends B {
    void callMe() {
	System.out.println("Metoda klasy C");
    }
}

class DynMetodDemo {
    public static void main (String args[]) {
	A a = new A(); // obiekt klasy A
	B b = new B(); // obiekt klasy B
	C c = new C(); // obiekt klasy C
	
	A r; // referencja klasy A (nadrzêdnej)

	r = a;      // wskazujemy na obiekt klasy A
	r.callMe(); // wywo³anie wersji A callMe

	r = b;      // wskazujemy na obiekt klasy B
	r.callMe(); // wywo³anie wersji B callMe

	r = c;      // wskazujemy na obiekt klasy C
	r.callMe(); // wywo³anie wersji C callMe
    }
}
