package title3.jdbc.dao.impl;

import title3.jdbc.dao.EmployeeDao;
import title4.application.employee.model.EmployeeDto;
import title4.application.util.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

  Connection connection = null;
  PreparedStatement statement = null;
  ResultSet result;

  @Override
  public List<EmployeeDto> findAll() {
    List<EmployeeDto> employeeList = new ArrayList<>();

    try {
      connection = SingletonConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "SELECT code, name, contract_date, department_code FROM employees;";
      statement = connection.prepareStatement(sqlStatement);
      result = statement.executeQuery();

      while (result.next()) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCode(result.getInt("code"));
        employeeDto.setName(result.getString("name"));
        employeeDto.setContractDate(result.getDate("contract_date"));
        employeeDto.setDepartmentCode(result.getInt("department_code"));

        employeeList.add(employeeDto);
      }

    } catch (SQLException throwable) {
      throwable.printStackTrace();

    } finally {
      rollback();
    }

    return employeeList;
  }

  @Override
  public EmployeeDto findByCode(int code) {
    EmployeeDto employee = null;

    try {
      connection = SingletonConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "SELECT code, name, contract_date, department_code FROM employees "
          .concat("WHERE code = ?");
      statement = connection.prepareStatement(sqlStatement);
      statement.setInt(1, code);
      result = statement.executeQuery();

      if (result.next()) {
        employee.setCode(result.getInt("code"));
        employee.setName(result.getString("name"));
        employee.setContractDate(result.getDate("contract_date"));
        employee.setDepartmentCode(result.getInt("department_code"));
      }

    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      rollback();
    }

    return employee;
  }

  @Override
  public void save(EmployeeDto employee) {
    try {
      connection = SingletonConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "INSERT INTO employees (name, document_identification, contract_date, contract_type, department_code) "
          .concat("VALUES (?, ?, ?, ?, ?);");
      statement = connection.prepareStatement(sqlStatement);
      statement.setString(1, employee.getName());
      statement.setInt(2, employee.getDocumentIdentification());
      statement.setDate(3, employee.getContractDate());
      statement.setString(4, employee.getContractType());
      statement.setInt(5, employee.getDepartmentCode());

      int insertedRows = statement.executeUpdate();
      if (insertedRows == 1) {
        connection.commit();
      } else {
        throw new RuntimeException("Error al insertar");
      }
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      rollback();
    }
  }

  @Override
  public void deleteByCode(int code) throws SQLException {
    try {
      connection = SingletonConnection.getConnection();
      connection.setAutoCommit(false);

      String sqlStatement = "DELETE FROM employees WHERE code = ?";
      statement = connection.prepareStatement(sqlStatement);
      statement.setInt(1, code);

      int deletedRows = statement.executeUpdate();
      if (deletedRows == 1) {
        connection.commit();
      } else {
        throw new RuntimeException("Error al eliminar");
      }
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      rollback();
    }
  }

  private void rollback() {
    try {
      if (connection != null) {
        connection.rollback();
      }
      if (statement != null) {
        statement.close();
      }
      if (result != null) {
        result.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
