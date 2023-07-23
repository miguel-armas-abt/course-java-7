package title2.poo.date.models;

public class Date {

  private int day;
  private int month;
  private int year;

  public Date() {}

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String toString(){
    return this.day + "/" + this.month + "/" + this.year;
  }

  public boolean equals(Object object) {
    Date otherDate = (Date) object;
    return (otherDate.day == this.day && otherDate.month == this.month && otherDate.year == this.year);
  }
}
