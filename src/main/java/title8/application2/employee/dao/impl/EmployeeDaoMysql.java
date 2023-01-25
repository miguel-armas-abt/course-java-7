package title8.application2.employee.dao.impl;

import title8.application2.employee.dao.EmployeeDao;

public class EmployeeDaoMysql extends EmployeeDao {

  @Override
  public String getQueryToGetLatestEmployees(){
    String selectQuery = "";
    selectQuery += "SELECT code, name, contract_date, department_code ";
    selectQuery += "FROM employees ";
    selectQuery += "ORDER BY contract_date DESC ";
    selectQuery += "LIMIT ? ";
    return selectQuery;
  }

}
