package title8.application.department.domain.model;

import java.io.Serializable;

/**
 * <br/> El objetivo del patrón DTO es encapsular los datos de un modelo simple y sin lógica de negocio para facilitar
 * su transporte entre diferentes componentes. <br/>
 */
public class DepartmentDto implements Serializable {

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
