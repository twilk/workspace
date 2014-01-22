// przyk³ad wywo³añ polimorficznych z wykorzystaniem 
// zmiennych this i super
class A { 
    int m() { 
	return 1; 
    }
    int test() { 
	return m(); 
    }
    int testThis() { 
	return this.test(); 
    }
}

class B extends A { 
    int m(){ 
	return 2; 
    }
    int testSuper() { 
	return super.test(); 
    }
}

class C extends B { 
    int m() {
	return 3; 
    }
    int testSuper() { 
	return super.m(); 
    }
}

class DynWiaDemo {
    public static void main(String[] args) {
	A a = new A() ;
	B b = new B() ;
	C c = new C() ;

	System.out.println(a.test() + " " + a.testThis());
	System.out.println(b.test() + " " + b.testSuper() + " " + 
			   b.testThis());
	System.out.println(c.test() + " " + c.testSuper() + " " + 
			   c.testThis());
  }
}
