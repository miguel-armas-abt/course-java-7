package title8.application2.department.facade;

import title8.application2.department.model.DepartmentDto;

import java.util.List;

/**
 * <br/>Interface Facade que define los métodos necesarios para separar la lógica de acceso a datos
 * de la lógica de negocio del contexto Department.<br/>
 *
 * <b>Interface</b>: DepartmentFacade<br/>
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
public interface DepartmentFacade {

  List<DepartmentDto> findAll();
}
