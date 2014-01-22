public class Rzutowania {
    public static void main(String[] args){
	byte a = 5, b = 6;
	a = a + 2; 
	a = a * 2; 
	a = a + b;

	short c = 1001, d = 1002;
	c = c + 2;
	c = c * 2;
	c = c + b;
	c = c * b;

	int e = 3;
	e = e * c;
	c = e ;
	e = c;

	double g = 5.21;
	e = 2 * g;
	g = e;

	byte x = 100,  y;
	y = x + x + x ;
	System.out.println("Proste dodawanie 100 + 100 + 100  = " + y );
    }

}
