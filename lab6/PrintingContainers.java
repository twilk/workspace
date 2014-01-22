//: c09:PrintingContainers.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Containers print themselves automatically.
import java.util.*;

public class PrintingContainers {
  static Collection <String> fill(Collection <String> c) {
    c.add("dog");
    c.add("dog");
    c.add("cat");
    return c;
  }
  static Map <String, String> fill(Map<String, String> m) {
    m.put("dog", "Bosco");
    m.put("dog", "Spot");
    m.put("cat", "Rags");
    return m;
  }
  public static void main(String[] args) {
    System.out.println(fill(new ArrayList<String>()));
    System.out.println(fill(new HashSet<String>()));
    System.out.println(fill(new HashMap<String, String>()));
  }
} ///:~
