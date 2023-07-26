package title8.application.department.infrastructure.facade;

import title8.application.department.infrastructure.dao.DepartmentDatabaseDAO;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;
import java.util.List;

public class DepartmentFacadeDatabase implements DepartmentFacade {

  @Override
  public List<DepartmentDto> findAll() {
    DepartmentDatabaseDAO departmentDatabaseDAO = (DepartmentDatabaseDAO) ObjectFactory.build(ClassesProperties.departmentDaoClass);
    return departmentDatabaseDAO.findAll();
  }
}
