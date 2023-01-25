package title4.application.department.facade.impl;

import static title4.application.util.constant.Constant.DEPARTMENT_DAO_CLASS;

import title4.application.department.dao.DepartmentDao;
import title4.application.department.facade.DepartmentFacade;
import title4.application.department.model.DepartmentDto;
import title4.application.util.Factory;
import java.util.List;

/**
 * <br/>Clase Facade que implementa los métodos necesarios para separar la lógica de acceso a datos
 * de la lógica de negocio del contexto Department.<br/>
 *
 * <b>Class</b>: DepartmentFacadeImpl<br/>
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
public class DepartmentFacadeImpl implements DepartmentFacade {

  @Override
  public List<DepartmentDto> findAll() {
    DepartmentDao departmentDao = (DepartmentDao) Factory.build(DEPARTMENT_DAO_CLASS);
    return departmentDao.findAll();
  }
}
