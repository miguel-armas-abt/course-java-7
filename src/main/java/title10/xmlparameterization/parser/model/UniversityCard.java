package title10.xmlparameterization.parser.model;

public class UniversityCard {

  private int year;
  private String expirationDate;
  private Student student;

  public UniversityCard() {
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
