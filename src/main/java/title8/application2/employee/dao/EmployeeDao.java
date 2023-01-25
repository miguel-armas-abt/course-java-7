package title8.application2.employee.dao;

import title8.application2.employee.model.EmployeeDto;
import title8.application2.util.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class EmployeeDao {

  protected abstract String getQueryToGetLatestEmployees();

  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    try {
      connection = SingletonConnection.getConnectionPool().getConnection();
      String sqlStatement = "SELECT code, name, contract_date, department_code FROM employees WHERE department_code = ? ";
      statement = connection.prepareStatement(sqlStatement);
      statement.setInt(1, departmentCode);
      result = statement.executeQuery();

      List<EmployeeDto> employeeList = new ArrayList<>();
      EmployeeDto employee = null;

      while (result.next()) {
        employee = new EmployeeDto();
        employee.setCode(result.getInt("code"));
        employee.setName(result.getString("name"));
        employee.setContractDate(result.getDate("contract_date"));
        employee.setDepartmentCode(result.getInt("department_code"));
        employeeList.add(employee);
      }
      return employeeList;

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);

    } finally {
      try {
        if (result != null) {
          result.close();
        }
        if (statement != null) {
          statement.close();
        }
        if (connection != null) {
          SingletonConnection.getConnectionPool().releaseConnection(connection);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
      }
    }
  }

  public List<EmployeeDto> findLatestEmployees(int latest) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    try {
      connection = SingletonConnection.getConnectionPool().getConnection();

      String sqlStatement = getQueryToGetLatestEmployees();

      statement = connection.prepareStatement(sqlStatement);
      statement.setInt(1, latest);
      result = statement.executeQuery();

      List<EmployeeDto> employeeList = new ArrayList<>();
      EmployeeDto employee = null;

      while (result.next()) {
        employee = new EmployeeDto();
        employee.setCode(result.getInt("code"));
        employee.setName(result.getString("name"));
        employee.setContractDate(result.getDate("contract_date"));
        employee.setDepartmentCode(result.getInt("department_code"));
        employeeList.add(employee);
      }
      return employeeList;

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();

    } finally {
      try {
        if (result != null) {
          result.close();
        }
        if (statement != null) {
          statement.close();
        }
        if (connection != null) {
          SingletonConnection.getConnectionPool().releaseConnection(connection);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
      }
    }
  }

}
