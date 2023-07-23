package title8.application.department.infrastructure.repository.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.infrastructure.database.config.DatabaseConnection;

/**
 * Patrón de diseño DAO. Útil para realizar consultas a base de datos haciendo uso de instrucciones SQL nativas.
 *
 * connection.setAutoCommit(false): Las transacciones en BD no se confirmarán automáticamente. A continuación, debes confirmar o deshacer explícitamente mediante commit o rollback, respectivamente
 * connection.commit(): Confirmamos la transacción al finalizar la operación exitosamente
 * connection.rollback(): Deshacemos la transacción en caso de excepción
 */
public class DepartmentDao {

  private Connection connection = null;
  private PreparedStatement statement = null;
  private ResultSet result = null;

  public List<DepartmentDto> findAll() {
    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement("SELECT code, name, location FROM departments ");
      result = statement.executeQuery();

      List<DepartmentDto> departmentList = new ArrayList<>();
      while (result.next()) {
        DepartmentDto department = new DepartmentDto();
        department.setCode(result.getInt("code"));
        department.setName(result.getString("name"));
        department.setLocation(result.getString("location"));
        departmentList.add(department);
      }
      connection.commit();
      return departmentList;

    } catch (Exception ex) {
      rollback();
      throw new RuntimeException("error to find all departments: " + ex.getMessage());
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

