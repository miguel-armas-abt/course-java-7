package title2.poo.polymorphism.geometry.model;

public abstract class GeometricFigure {

  private String name;

  public GeometricFigure(String name) {
    this.name = name;
  }

  public abstract double calculateArea(); // metodo abstracto

  public static double calculateAverageArea(GeometricFigure arr[]) {
    int sum = 0;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[i].calculateArea();
    }
    return sum/arr.length;
  }

  public String toString(){
    return name + " (area = " + calculateArea() + ") ";
  }
}
