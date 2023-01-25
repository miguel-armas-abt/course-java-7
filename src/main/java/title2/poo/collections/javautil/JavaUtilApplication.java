package title2.poo.collections.javautil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class JavaUtilApplication {

  public static void main(String[] args) {

    // collection y arraylist de java util
    Collection<Integer> collection = new ArrayList<>();
    collection.add(1);
    collection.add(2);
    collection.add(3);

    // vector de javautil
    Vector<Integer> vector = new Vector<>();
    vector.add(1);
    vector.add(2);
    vector.add(3);

    System.out.println(collection);
    System.out.println(vector);
  }
}
