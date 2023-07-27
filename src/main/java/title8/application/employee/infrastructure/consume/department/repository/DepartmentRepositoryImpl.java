package title8.application.employee.infrastructure.consume.department.repository;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.employee.infrastructure.consume.department.facade.DepartmentFacade;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class DepartmentRepositoryImpl implements DepartmentRepository {

  private final DepartmentFacade departmentFacade = (DepartmentFacade) ObjectFactory.build(ClassesProperties.DEPARTMENT_FACADE_CLASS);

  @Override
  public List<DepartmentDto> findAll() {
    return departmentFacade.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return departmentFacade.findByCode(code);
  }
}
