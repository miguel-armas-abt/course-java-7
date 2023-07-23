package title8.application.department.application.service;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio
 * del contexto Department.<br/>
 */
public interface DepartmentService {

  List<DepartmentDto> findAll();
}
