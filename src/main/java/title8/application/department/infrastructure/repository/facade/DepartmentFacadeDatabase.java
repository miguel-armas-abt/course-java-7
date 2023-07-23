package title8.application.department.infrastructure.repository.facade;

import title8.application.department.infrastructure.repository.database.DepartmentDao;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;
import java.util.List;

public class DepartmentFacadeDatabase implements DepartmentFacade {

  @Override
  public List<DepartmentDto> findAll() {
    DepartmentDao departmentDao = (DepartmentDao) ObjectFactory.build(ClassesProperties.departmentDaoClass);
    return departmentDao.findAll();
  }
}
