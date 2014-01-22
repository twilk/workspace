import java.util.*;

class Hamster {
  private int hamsterNumber;
  Hamster(int i) { hamsterNumber = i; }
  public String toString() {
    return "This is Hamster #" + hamsterNumber;
  }
}

class Printer {
    static void printAll(List <Hamster> hl) {
	for (int i = 0; i < hl.size(); i++)
	    System.out.println(hl.get(i));
	
	// Uwaga! Nowa skladnia - wzbogacona petla for 
	//for (Hamster h : hl)
	//       System.out.println(h);
    }
}

public class HamsterMaze {
  public static void main(String[] args) {
      List<Hamster> v = new ArrayList<Hamster>();      
      for(int i = 0; i < 3; i++)
	  v.add(new Hamster(i));
      
      Printer.printAll(v);
  }
} ///:~
