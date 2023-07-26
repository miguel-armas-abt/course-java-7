package title8.application.employee.infrastructure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.infrastructure.database.config.DatabaseConnection;

public abstract class EmployeeDatabaseDAO {

  protected abstract String getQueryToGetLatestEmployees();
  private Connection connection = null;
  private PreparedStatement statement = null;
  private ResultSet result = null;

  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement("SELECT code, name, contract_date, department_code FROM employees WHERE department_code = ? ");
      statement.setInt(1, departmentCode);
      result = statement.executeQuery();

      List<EmployeeDto> employeeList = new ArrayList<>();
      while (result.next()) {
        EmployeeDto employee = new EmployeeDto();
        employee.setCode(result.getInt("code"));
        employee.setName(result.getString("name"));
        employee.setContractDate(result.getDate("contract_date"));
        employee.setDepartmentCode(result.getInt("department_code"));

        employeeList.add(employee);
      }
      connection.commit();
      return employeeList;

    } catch (Exception exception) {
      rollback();
      throw new RuntimeException("error to find employees by department code: " + exception.getMessage());

    } finally {
      closeResources();
    }
  }

  public List<EmployeeDto> findLatestEmployees(int latest) {
    try {
      connection = DatabaseConnection.getConnection();
      statement = connection.prepareStatement(getQueryToGetLatestEmployees());
      statement.setInt(1, latest);
      result = statement.executeQuery();

      List<EmployeeDto> employeeList = new ArrayList<>();
      while (result.next()) {
        EmployeeDto employee = new EmployeeDto();
        employee.setCode(result.getInt("code"));
        employee.setName(result.getString("name"));
        employee.setContractDate(result.getDate("contract_date"));
        employee.setDepartmentCode(result.getInt("department_code"));

        employeeList.add(employee);
      }
      connection.commit();
      return employeeList;

    } catch (Exception exception) {
      rollback();
      throw new RuntimeException("error to find latest employees: " + exception.getMessage());

    } finally {
      closeResources();
    }
  }

  private void rollback() {
    try {
      if (connection != null) {
        connection.rollback();
      }
    } catch (Exception exception) {
      throw new RuntimeException("error to rollback: " + exception.getMessage());
    }
  }

  private void closeResources() {
    try {
      if (statement != null) {
        statement.close();
      }
      if (result != null) {
        result.close();
      }
    } catch (Exception exception) {
      throw new RuntimeException("error to close resources: " + exception.getMessage());
    }
  }

}
