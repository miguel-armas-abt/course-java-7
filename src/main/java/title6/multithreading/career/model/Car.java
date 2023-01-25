package title6.multithreading.career.model;

public class Car {

  private String name;
  private int advancePercentage;

  public Car(String name, int advancePercentage) {
    this.name = name;
    this.advancePercentage = advancePercentage;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAdvancePercentage() {
    return advancePercentage;
  }

  public void setAdvancePercentage(int advancePercentage) {
    this.advancePercentage = advancePercentage;
  }

}
