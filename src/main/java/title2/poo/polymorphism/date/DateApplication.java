package title2.poo.polymorphism.date;

import title2.poo.polymorphism.date.model.Date;
import title2.poo.polymorphism.date.model.DateWithHour;
import title2.poo.polymorphism.date.model.DetailedDate;
import title2.poo.polymorphism.date.service.DateService;
import title2.poo.polymorphism.date.service.impl.DateServiceImpl;
import title2.poo.polymorphism.date.util.UtilityFunctions;

public class DateApplication {

  public static void main(String[] args) {

    DateService dateService = new DateServiceImpl();
//    dateService.compareDates();
//    dateService.addDays();

    System.out.println("***************************** polimorfismo");
    Object date = new Date(1,3,1999);
    System.out.println(date);

    Date detailedDate = new DetailedDate("1/3/1999");
    System.out.println(detailedDate);

    Date dateWithHour = new DateWithHour("1/3/1999", 17,54,15);
    System.out.println(dateWithHour);

    System.out.println("\n\n***************************** método estático");
    Object[] objectArray = {
        new Date(1,3,1999),
        new DetailedDate("1/3/1999"),
        new String ("Esto es una cadena"),
        new Integer(34)
    };

    UtilityFunctions.printObjects(objectArray);

  }
}
