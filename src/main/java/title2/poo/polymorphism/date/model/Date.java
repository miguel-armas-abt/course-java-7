package title2.poo.polymorphism.date.model;

public class Date {

  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Date() {}

  public Date(String formattedDate) {
    this.getDate(formattedDate);
  }

  private int dateToDays() {
    return this.year * 360 + this.month * 30 + this.day;
  }

  private void daysToDate(int days) {
    this.year = (int) days/360;
    int residual = days % 360;
    this.month = (int)residual/30;
    this.day = residual % 30;

    if(this.day == 0) {
      this.day = 30;
      this.month--;
    }
    if(month == 0) {
      this.month = 12;
      this.year--;
    }
  }

  public void addDays(int days) {
    int totalDays = dateToDays() + days;
    daysToDate(totalDays);
  }

  public String toString(){
    return this.day + "/" + this.month + "/" + this.year;
  }

  public boolean equals(Object object) {
    Date otherDate = (Date) object;
    return (otherDate.day == this.day && otherDate.month == this.month && otherDate.year == this.year);
  }

  private void getDate(String formattedDate)
  {
    int firstOccurrence = formattedDate.indexOf('/');
    int lastOccurrence = formattedDate.lastIndexOf('/');

    String actualDay = formattedDate.substring(0,firstOccurrence);
    this.day = Integer.parseInt(actualDay);

    String actualMonth = formattedDate.substring(firstOccurrence+1, lastOccurrence);
    this.month = Integer.parseInt(actualMonth);

    String actualYear = formattedDate.substring(lastOccurrence+1);
    this.year = Integer.parseInt(actualYear);
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
}
