package title8.application2.department.dao;

import title8.application2.department.model.DepartmentDto;
import title8.application2.util.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

  public List<DepartmentDto> findAll() {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    try {
      connection = SingletonConnection.getConnectionPool().getConnection();
      String sqlStatement = "SELECT code, name, location FROM departments ";
      statement = connection.prepareStatement(sqlStatement);
      result = statement.executeQuery();

      List<DepartmentDto> departmentList = new ArrayList<>();

      DepartmentDto department = null;

      while (result.next()) {
        department = new DepartmentDto();
        department.setCode(result.getInt("code"));
        department.setName(result.getString("name"));
        department.setLocation(result.getString("location"));
        departmentList.add(department);
      }
      return departmentList;

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
}

