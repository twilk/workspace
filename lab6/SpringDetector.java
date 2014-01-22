import java.util.*;

class Groundhog {
  int ghNumber;
  Groundhog(int n) { ghNumber = n; }
}

class Prediction {
  boolean shadow = Math.random() > 0.5;
  public String toString() {
    if(shadow)
      return "Six more weeks of Winter!";
    else
      return "Early Spring!";
  }
}

public class SpringDetector {
  public static void main(String[] args) {
    HashMap<Groundhog, Prediction> hm = new HashMap<Groundhog, Prediction>();
    for(int i = 0; i < 10; i++)
      hm.put(new Groundhog(i), new Prediction());

    // Wypisanie zawartosci calego odwzorowania
    System.out.println("hm = " + hm + "\n");

    System.out.println(
      "Looking up prediction for Groundhog #3:");
    Groundhog gh = new Groundhog(3);
    if(hm.containsKey(gh))
      System.out.println((Prediction)hm.get(gh));
    else
      System.out.println("Key not found: " + gh);
  }
} ///:~
