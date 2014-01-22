// Przyk³ad b³êdnego nadpisywania klas finalnych

class A {
    final void finalMethod() {
	System.out.println("To jest metoda finalna");
    }
}

class B extends A {
    // B£¡D: próbujemy nadpisaæ metodê finaln±
    void finalMethod() {
	System.out.println("To jest nielegalne");
    }
}

//klasa testuj±ca
class FinalMethodTest {
    public static void main(String args[]) {
	A a = new A();
	B b = new B();

	a.finalMethod();
	b.finalMethod();
    }
}
