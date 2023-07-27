package title8.application.employee.infrastructure.consume.department.facade;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.employee.infrastructure.consume.department.dao.DepartmentTCPDAO;

public class DepartmentFacadeTCP implements DepartmentFacade {

  @Override
  public List<DepartmentDto> findAll() {
    return (List<DepartmentDto>) DepartmentTCPDAO.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return DepartmentTCPDAO.findByCode(code);
  }
}
