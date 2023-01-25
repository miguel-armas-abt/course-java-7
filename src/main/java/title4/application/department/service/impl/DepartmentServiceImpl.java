package title4.application.department.service.impl;

import title4.application.department.facade.DepartmentFacade;
import title4.application.department.facade.impl.DepartmentFacadeImpl;
import title4.application.department.model.DepartmentDto;
import title4.application.department.service.DepartmentService;
import java.util.List;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio
 * del contexto Department.<br/>
 *
 * <b>Class</b>: DepartmentServiceImpl<br/>
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
public class DepartmentServiceImpl implements DepartmentService {

  private static DepartmentFacade departmentFacade = new DepartmentFacadeImpl();

  @Override
  public void findAll() {
    List<DepartmentDto> departmentList = departmentFacade.findAll();
    for (DepartmentDto department: departmentList) {
      System.out.println(department.toString());
    }
  }
}
