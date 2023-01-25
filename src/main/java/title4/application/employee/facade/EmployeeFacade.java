package title4.application.employee.facade;

import title4.application.employee.model.EmployeeDto;
import java.util.List;

/**
 * <br/>Interface Facade que define los métodos necesarios para separar la lógica de acceso a datos
 * de la lógica de negocio del contexto Employee.<br/>
 *
 * <b>Interface</b>: EmployeeFacade<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
public interface EmployeeFacade {

  List<EmployeeDto> findLatestEmployeesByDate(int latest);

  List<EmployeeDto> findByDepartmentCode(int departmentCode);

}
