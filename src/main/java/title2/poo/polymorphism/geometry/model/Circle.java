package title2.poo.polymorphism.geometry.model;

public class Circle extends GeometricFigure{

  private double radius;

  public Circle(double radius) {
    super("Círculo");
    this.radius = radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * Math.pow(radius, 2);
  }
}
