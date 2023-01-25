package title4.application.employee.model;

import java.sql.Date;

public class EmployeeDto {

  private int code;
  private String name;
  private int documentIdentification;
  private Date contractDate;
  private String contractType;
  private int departmentCode;

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

  public int getDocumentIdentification() {
    return documentIdentification;
  }

  public void setDocumentIdentification(int documentIdentification) {
    this.documentIdentification = documentIdentification;
  }

  public Date getContractDate() {
    return contractDate;
  }

  public void setContractDate(Date contractDate) {
    this.contractDate = contractDate;
  }

  public String getContractType() {
    return contractType;
  }

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }

  public int getDepartmentCode() {
    return departmentCode;
  }

  public void setDepartmentCode(int departmentCode) {
    this.departmentCode = departmentCode;
  }

  @Override
  public String toString() {
    return "EmployeeDto{" +
        "number=" + code +
        ", name='" + name + '\'' +
        ", contractDate=" + contractDate +
        ", departmentCode='" + departmentCode + '\'' +
        '}';
  }

}
