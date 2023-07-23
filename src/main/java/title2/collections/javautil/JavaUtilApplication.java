package title2.collections.javautil;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JavaUtilApplication {

  public static void main(String[] args) {

    // list y arraylist de javautil
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    // vector de javautil
    Vector<Integer> vector = new Vector<>();
    vector.add(1);
    vector.add(2);
    vector.add(3);

    System.out.println(list);
    System.out.println(vector);
  }
}
