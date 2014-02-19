package mleko;
class Liczby{
	private int a = -1;
	static int b = 4;
	
	Liczby(int i){
		a = a + i;
		b = a + b;
	}
	
	Liczby(){
		b = a + 3;
		a = b + a;
	}
	void wyswietl(){
		System.out.println("a = "+ a + " b = " + b);
	}
	
	static {
		b = b * 2;
	}
}
public class QQ {

	public static void main(String[] args) {
		System.out.println(Liczby.b);
		Liczby.b--;
		Liczby licz1 = new Liczby(1);
		licz1.wyswietl();
		Liczby licz2 = new Liczby(-1);
		Liczby licz3 = new Liczby();
		licz2.wyswietl();
		licz3.wyswietl();
		
		
	}

}
