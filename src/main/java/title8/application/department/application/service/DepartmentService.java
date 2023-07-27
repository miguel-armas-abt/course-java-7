package title8.application.department.application.service;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;

/**
 * <br/>Componente Service que define los métodos necesarios para tramitar la lógica de negocio.<br/>
 */
public interface DepartmentService {

  List<DepartmentDto> findAll();

  DepartmentDto findByCode(int code);
}
