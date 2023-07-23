package title2.poo.date.util;

public class UtilFunction {

  private UtilFunction() {}
  public static void printObjects(Object[] objectArray) {
    for(int i = 0; i < objectArray.length; i++) {
      System.out.println("arr["+i+"] = " + objectArray[i]);
    }
  }

}
