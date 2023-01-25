package title2.poo.polymorphism.date.model;

public class DateWithHour extends DetailedDate {

  private int hour;
  private int minute;
  private int second;

  public DateWithHour(String formattedDate, int hour, int minute, int second) {
    super(formattedDate);
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public String toString() {
    return super.toString() + " (" + hour + ":" + minute + ":" + second + ")";
  }

}
