package title8.application2.department.facade.impl;

import title8.application2.department.facade.DepartmentFacade;
import title8.application2.department.model.DepartmentDto;
import title8.application2.server.tcp.TcpServiceLocator;
import java.util.List;

public class DepartmentFacadeTcp implements DepartmentFacade {

  @Override
  public List<DepartmentDto> findAll() {
    return (List<DepartmentDto>) TcpServiceLocator.findAllDepartments();
  }
}
