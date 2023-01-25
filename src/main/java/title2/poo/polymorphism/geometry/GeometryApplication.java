package title2.poo.polymorphism.geometry;

import title2.poo.polymorphism.geometry.model.Circle;
import title2.poo.polymorphism.geometry.model.GeometricFigure;
import title2.poo.polymorphism.geometry.model.Rectangle;
import title2.poo.polymorphism.geometry.model.Triangle;

public class GeometryApplication {

  public static void main(String[] args) {

    GeometricFigure[] geometricFigureArray = {
      new Rectangle(2, 5),
      new Circle(5),
      new Triangle(9, 7)
    };

    for(int i = 0; i < geometricFigureArray.length; i++) {
      System.out.println(geometricFigureArray[i]);
    }

    double average = GeometricFigure.calculateAverageArea(geometricFigureArray);
    System.out.println("promedio: " + average);

  }
}
