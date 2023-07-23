package title2.poo.date.formatters;

public class DateFormatterWithHour extends DetailedDateFormatter {

  private int hour;
  private int minute;
  private int second;

  public DateFormatterWithHour(String formattedDate, int hour, int minute, int second) {
    super(formattedDate);
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public String toString() {
    return super.toString() + " (" + hour + ":" + minute + ":" + second + ")";
  }

}
