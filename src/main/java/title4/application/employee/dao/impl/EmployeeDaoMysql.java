package title4.application.employee.dao.impl;

import title4.application.employee.dao.EmployeeDao;

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
