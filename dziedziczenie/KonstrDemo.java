// Demonstracja kolejności wywołania konstruktorów

class A {
    A() {
	System.out.println("Konstruktor z A");
    }
}

class B extends A {
    B() {
	System.out.println("Konstruktor z B");
    }
}

class C extends B {
    C() {
	System.out.println("Konstruktor z C");
    }
}
// klasa testująca
class KonstrDemo {
    public static void main (String args[]) {
	C c = new C();
    }
}
