package title3.jdbc.dao;

import title4.application.employee.model.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

  List<EmployeeDto> findAll();

  EmployeeDto findByCode(int code);

  void save(EmployeeDto employee);

  void deleteByCode(int code) throws SQLException;
}
