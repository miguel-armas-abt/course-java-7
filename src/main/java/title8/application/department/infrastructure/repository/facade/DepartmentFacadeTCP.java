package title8.application.department.infrastructure.repository.facade;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.repository.webservice.DepartmentTCPConnectorService;

public class DepartmentFacadeTCP implements DepartmentFacade {

  @Override
  public List<DepartmentDto> findAll() {
    return (List<DepartmentDto>) DepartmentTCPConnectorService.findAll();
  }
}
