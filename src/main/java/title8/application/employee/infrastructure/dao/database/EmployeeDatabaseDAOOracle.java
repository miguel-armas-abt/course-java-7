package title8.application.employee.infrastructure.dao.database;

import title8.application.employee.infrastructure.dao.EmployeeDatabaseDAO;

public class EmployeeDatabaseDAOOracle extends EmployeeDatabaseDAO {

  @Override
  public String getQueryToGetLatestEmployees(){
    String selectQuery = "";
    selectQuery += "SELECT number, name, contract_date, department_code ";
    selectQuery += "FROM employees ";
    selectQuery += "ORDER BY contract_date DESC ";
    selectQuery += "LIMIT ? ";
    return selectQuery;
  }

}