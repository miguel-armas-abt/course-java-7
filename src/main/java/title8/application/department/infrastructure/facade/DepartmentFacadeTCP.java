package title8.application.department.infrastructure.facade;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.dao.DepartmentTCPDAO;

public class DepartmentFacadeTCP implements DepartmentFacade {

  @Override
  public List<DepartmentDto> findAll() {
    return (List<DepartmentDto>) DepartmentTCPDAO.findAll();
  }
}
