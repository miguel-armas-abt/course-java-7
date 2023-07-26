package title8.application.department.infrastructure.repository;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;

/**
 * <br/> El objetivo del patrón Repository es proporcionar una interfaz para acceder a los datos sin exponer los
 * detalles de almacenamiento. <br/>
 */
public interface DepartmentRepository {

  List<DepartmentDto> findAll();
}
