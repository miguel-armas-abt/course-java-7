package title2.poo.date.formatters;

public class DetailedDateFormatter extends DateFormatter {

  public DetailedDateFormatter(String formattedDate) {
    super(formattedDate);
  }

  private static final String[] months = {
      "Enero", "Febrero", "Marzo", "Abril",
      "Mayo", "Junio", "Julio", "Agosto",
      "Setiembre", "Octubre", "Noviembre", "Diciembre"
  };

  public String toString() {
    return super.date.getDay()+ " de " + months[super.date.getMonth() - 1]+ " de " + super.date.getYear();
  }
}
