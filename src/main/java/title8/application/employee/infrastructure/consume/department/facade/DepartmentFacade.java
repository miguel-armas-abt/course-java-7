package title8.application.employee.infrastructure.consume.department.facade;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;

/**
 * <br/> El objetivo del patrón Facade es proporcionar una interfaz simple que unifique y oculte las complejidades internas de
 * un conjunto de clases o servicios. <br/>
 */
public interface DepartmentFacade {

  List<DepartmentDto> findAll();

  DepartmentDto findByCode(int code);
}
