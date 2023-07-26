package title8.application.department.infrastructure.repository;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.facade.DepartmentFacade;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class DepartmentRepositoryImpl implements DepartmentRepository{

  @Override
  public List<DepartmentDto> findAll() {
    return ((DepartmentFacade) ObjectFactory.build(ClassesProperties.departmentFacadeClass)).findAll();
  }
}
