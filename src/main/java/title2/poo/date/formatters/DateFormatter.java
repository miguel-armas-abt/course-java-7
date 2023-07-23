package title2.poo.date.formatters;

import title2.poo.date.models.Date;

public class DateFormatter {

  protected Date date;

  public DateFormatter(String formattedDate) {
    date = new Date();
    buildDate(formattedDate);
  }

  public Date getDate() {
    return this.date;
  }

  private void buildDate(String formattedDate) {
    int firstOccurrence = formattedDate.indexOf('/');
    int lastOccurrence = formattedDate.lastIndexOf('/');

    String actualDay = formattedDate.substring(0,firstOccurrence);
    this.date.setDay(Integer.parseInt(actualDay));

    String actualMonth = formattedDate.substring(firstOccurrence+1, lastOccurrence);
    this.date.setMonth(Integer.parseInt(actualMonth));

    String actualYear = formattedDate.substring(lastOccurrence+1);
    this.date.setYear(Integer.parseInt(actualYear));
  }

  public void addDays(int days) {
    int totalDays = dateToDays() + days;
    daysToDate(totalDays);
  }

  private int dateToDays() {
    return this.date.getYear() * 360 + this.date.getMonth() * 30 + this.date.getDay();
  }

  private void daysToDate(int days) {
    this.date.setYear(days/360);

    int residual = days % 360;
    this.date.setMonth(residual/30);

    this.date.setDay(residual % 30);

    if(date.getDay() == 0) {
      this.date.setDay(30);
      this.date.setMonth(this.date.getMonth() - 1);
    }
    if(this.date.getMonth() == 0) {
      this.date.setMonth(12);
      this.date.setYear(this.date.getYear() - 1);
    }
  }

  public String toString() {
    return this.date.toString();
  }
}
