package title2.poo.polymorphism.geometry.model;

public class Rectangle extends GeometricFigure{

  private double base;
  private double height;

  public Rectangle(double base, double height) {
    super("Rectángulo");
    this.base = base;
    this.height = height;
  }

  @Override
  public double calculateArea() {
    return base * height;
  }
}
