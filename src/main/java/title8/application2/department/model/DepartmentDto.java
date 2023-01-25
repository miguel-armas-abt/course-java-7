package title8.application2.department.model;

public class DepartmentDto {

  private int code;
  private String name;
  private String location;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return code + "," + name + "," + location;
  }

}
