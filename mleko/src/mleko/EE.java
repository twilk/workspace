package mleko;

import java.util.ArrayList;
import java.util.List;

public class EE extends Bazowa{
	public static void main(String[] args) {
		List<Figura> figury = new ArrayList<Figura>();
		figury.add(new Kwadrat(5));
		figury.add(new Trojkat(5, 10));
		figury.add(new Okrag(5));
		for(Figura m : figury){
			if (m instanceof Drawable) {
				Drawable d = (Drawable)m;
				d.draw();
			}
		}
	}
	
	public static double obliczPole(Figura figura) {
		return figura.pole();
	}
}

abstract class Figura {
	public Figura() {
		
	}
	
	void wyswietl() {
		System.out.println();
	}
	
	abstract double pole();
}

class Kwadrat extends Figura implements Drawable {
	
	double a;

	public Kwadrat(double a) {
		this.a = a;
	}
	
	public void draw() {
		System.out.println("Kwadrat");
	}
	
	double pole() {

		return a * a;
	}
	
}

class Trojkat extends Figura implements Drawable {
	
	double a;
	double h;

	public Trojkat(double d, double e) {
		a = d;
		h = e;
	}

	@Override
	double pole() {
		// TODO Auto-generated method stub
		return 0.5 * a * h;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Trojkat");
	}
	
}

class Okrag extends Figura {
	public double r;
	
	
	
	public Okrag(int r) {
		this.r = r;
	}



	public double getR() {
		return r;
	}



	public void setR(double r) {
		this.r = r;
	}



	@Override
	double pole() {

		return r * r * 3.14;
	}
	
}