package title2.poo.date;

import title2.poo.date.formatters.DateFormatter;
import title2.poo.date.formatters.DateFormatterWithHour;
import title2.poo.date.formatters.DetailedDateFormatter;

/**
 * Polimorfismo
 */
public class PolymorphismDateApplication {

  private static final String FORMATTED_DATE = "1/3/1999";

  public static void main(String[] args) {

    DateFormatter dateFormatter = new DateFormatter(FORMATTED_DATE);
    System.out.println(dateFormatter);

    DateFormatter detailedDateFormatter = new DetailedDateFormatter(FORMATTED_DATE);
    System.out.println(detailedDateFormatter);

    DateFormatter dateWithHourManager = new DateFormatterWithHour(FORMATTED_DATE, 17,54,15);
    System.out.println(dateWithHourManager);
  }
}
