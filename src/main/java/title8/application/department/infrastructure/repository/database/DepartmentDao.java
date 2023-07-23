package title8.application.department.infrastructure.repository.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.infrastructure.database.config.DatabaseConnection;

public class DepartmentDao {

  private Connection connection = null;
  private PreparedStatement statement = null;
  private ResultSet result = null;

  public List<DepartmentDto> findAll() {
    try {
      connection = DatabaseConnection.getConnection();
      statement = connection.prepareStatement("SELECT code, name, location FROM departments ");
      result = statement.executeQuery();

      List<DepartmentDto> departmentList = new ArrayList<>();
      DepartmentDto department;
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
      closeConnection();
    }
  }

  private void closeConnection() {
    try {
      if (result != null) {
        result.close();
      }
      if (statement != null) {
        statement.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }
}

