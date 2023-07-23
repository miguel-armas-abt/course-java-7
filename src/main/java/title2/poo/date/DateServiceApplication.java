package title2.poo.date;

import title2.poo.date.services.DateService;
import title2.poo.date.services.DateServiceImpl;

public class DateServiceApplication {

  public static void main(String[] args) {

    DateService dateService = new DateServiceImpl();
    dateService.compareDates();
    dateService.addDays();
  }
}
