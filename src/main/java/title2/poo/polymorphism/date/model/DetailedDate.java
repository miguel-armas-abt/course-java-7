package title2.poo.polymorphism.date.model;

public class DetailedDate extends Date {

  public DetailedDate(String formattedDate) {
    super(formattedDate);
  }

  private static String months [] = {
      "Enero", "Febrero", "Marzo", "Abril",
      "Mayo", "Junio", "Julio", "Agosto",
      "Setiembre", "Octubre", "Noviembre", "Diciembre"
  };

  public String toString() {
    return this.getDay()+ " de " + months[getMonth() - 1]+ " de " + this.getYear();
  }
}
