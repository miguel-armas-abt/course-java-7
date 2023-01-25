package title10.xmlparameterization.parser.model;

public class Faculty {

  private String facultyName;
  private University university;

  public Faculty() {
  }

  public String getFacultyName() {
    return facultyName;
  }

  public void setFacultyName(String facultyName) {
    this.facultyName = facultyName;
  }

  public University getUniversity() {
    return university;
  }

  public void setUniversity(University university) {
    this.university = university;
  }
}
