package title3.jdbc.dao;

import java.sql.SQLException;
import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;

public interface EmployeeDao {

  List<EmployeeDto> findAll();

  EmployeeDto findByCode(int code);

  void save(EmployeeDto employee);

  void deleteByCode(int code) throws SQLException;
}
