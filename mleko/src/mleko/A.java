package mleko;
class A {
	public static String pisz(A a){
		return "("+a+")";
	}
	public String toString(){
		return "A";
	}
	public String pisz(){
		//System.out.println(this);
		return pisz(this);
	}
	

	public static void main(String[] args){
		B b = new B();
		A c = new C();
		System.out.println(  b.pisz());
		System.out.println(C.pisz(c));
		System.out.println(c.pisz() );
	}

	public static class B extends A{
		public String toString(){
			System.out.println("dada");
			return "B";
		}
	}
	public static String pisz(B b){
		return "B";
	}
	public static class C extends A{
		public String toString(){
		return "C";
		}
		public String pisz(){
			return pisz(this);
		}
	}
	public static String pisz(C c){
		return "C";
	}
}
/*
public class Raz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/