// Przyk�ad b��dnego nadpisywania klas finalnych

class A {
    final void finalMethod() {
	System.out.println("To jest metoda finalna");
    }
}

class B extends A {
    // B��D: pr�bujemy nadpisa� metod� finaln�
    void finalMethod() {
	System.out.println("To jest nielegalne");
    }
}

//klasa testuj�ca
class FinalMethodTest {
    public static void main(String args[]) {
	A a = new A();
	B b = new B();

	a.finalMethod();
	b.finalMethod();
    }
}
