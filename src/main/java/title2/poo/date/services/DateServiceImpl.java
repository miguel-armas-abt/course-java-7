package title2.poo.date.services;

import java.util.Scanner;
import title2.poo.date.models.Date;
import title2.poo.date.formatters.DateFormatter;

public class DateServiceImpl implements DateService {

  private final Scanner scanner;

  public DateServiceImpl() {
    scanner = new Scanner(System.in);
  }

  @Override
  public boolean compareDates() {
    Date[] dateArray = new Date[2];
    boolean isEqual = false;

    for(int i = 0; i < 2; i ++) {
      System.out.print("Ingrese el día (ej: 1): ");
      int typedDay = this.scanner.nextInt();

      System.out.print("Ingrese el mes (ej: 3): ");
      int typedMonth = this.scanner.nextInt();

      System.out.print("Ingrese el año (ej: 1999): ");
      int typedYear = this.scanner.nextInt();

      dateArray[i] = new Date(typedDay, typedMonth, typedYear);
    }

    if (dateArray[0].equals(dateArray[1])) {
      isEqual = true;
      System.out.println("Fechas iguales.");
    } else {
      System.out.println("Fechas diferentes.");
    }

    return isEqual;
  }

  @Override
  public void addDays() {
    System.out.print("Ingrese fecha (dd/mm/aa): ");
    String formattedDate = scanner.next();
    DateFormatter dateFormatter = new DateFormatter(formattedDate);

    System.out.print("Ingrese los dias que desea agregar: ");
    int days = scanner.nextInt();
    dateFormatter.addDays(days);

    System.out.println("Fecha programada: " + dateFormatter.getDate());
  }

}
