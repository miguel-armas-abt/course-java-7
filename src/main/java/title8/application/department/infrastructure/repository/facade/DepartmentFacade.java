package title8.application.department.infrastructure.repository.facade;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;

/**
 * <br/>Interface Facade que define los métodos necesarios para separar la lógica de acceso a datos
 * de la lógica de negocio del contexto Department.<br/>
 */
public interface DepartmentFacade {

  List<DepartmentDto> findAll();
}
