package title8.application.department.infrastructure.consume.repository;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.consume.dao.DepartmentDatabaseDAO;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class DepartmentRepositoryImpl implements DepartmentRepository {
  private final DepartmentDatabaseDAO departmentDatabaseDAO = (DepartmentDatabaseDAO) ObjectFactory.build(ClassesProperties.DEPARTMENT_DATABASE_DAO_CLASS);

  @Override
  public List<DepartmentDto> findAll() {
    return departmentDatabaseDAO.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return departmentDatabaseDAO.findByCode(code);
  }
}
