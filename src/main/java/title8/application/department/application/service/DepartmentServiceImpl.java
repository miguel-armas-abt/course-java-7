package title8.application.department.application.service;

import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.repository.facade.DepartmentFacade;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;
import java.util.List;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio
 * del contexto Department.<br/>
 */
public class DepartmentServiceImpl implements DepartmentService {

  @Override
  public List<DepartmentDto> findAll() {
    return ((DepartmentFacade) ObjectFactory.build(ClassesProperties.departmentFacadeClass)).findAll();
  }
}
