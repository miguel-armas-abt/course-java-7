package title6.multithreading.career.model;

import java.util.Observable;

/**
 * Subject.
 */
public class SubjectCar extends Observable implements Runnable {

  private Car car;

  public SubjectCar(Car car) {
    this.car = car;
  }

  private void advance() {
    int randomNumber = getRandomNumber(1, 5);
    int actualPercentage = randomNumber + car.getAdvancePercentage();
    System.out.println(this.toString(actualPercentage));
    car.setAdvancePercentage(actualPercentage);
  }

  public static int getRandomNumber(int minimum, int maximum){
    return (int)Math.floor(Math.random() * (maximum - minimum + 1) + minimum);
  }

  @Override
  public void run() {
    try {
      while (car.getAdvancePercentage() < 100){
        this.advance();
        setChanged();
        notifyObservers(car.getAdvancePercentage());
        clearChanged();
        Thread.sleep(300);
      }
    } catch (InterruptedException ex) {
      System.out.println("Interrupted thread.");
    }
  }

  public Car getCar() {
    return car;
  }

  public String toString(int actualPercentage) {
    return car.getName() + " aumentó en "
        + (actualPercentage - car.getAdvancePercentage()) + "%" + ": " + actualPercentage + "%";
  }
}
