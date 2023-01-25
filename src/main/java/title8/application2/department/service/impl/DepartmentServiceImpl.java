package title8.application2.department.service.impl;

import static title8.application2.util.constant.Constant.DEPARTMENT_FACADE_CLASS;

import title8.application2.department.facade.DepartmentFacade;
import title8.application2.department.model.DepartmentDto;
import title8.application2.department.service.DepartmentService;
import title8.application2.util.Factory;
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

  private static DepartmentFacade departmentFacade = (DepartmentFacade) Factory.build(DEPARTMENT_FACADE_CLASS);

  @Override
  public void findAll() {
    List<DepartmentDto> departmentList = departmentFacade.findAll();
    for (DepartmentDto department: departmentList) {
      System.out.println(department.toString());
    }
  }
}
