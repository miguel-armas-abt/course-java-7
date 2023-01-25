package title8.application2.employee.facade.impl;

import title8.application2.employee.facade.EmployeeFacade;
import title8.application2.employee.model.EmployeeDto;
import title8.application2.server.tcp.TcpServiceLocator;
import java.util.List;

public class EmployeeFacadeTcp implements EmployeeFacade {

  @Override
  public List<EmployeeDto> findLatestEmployeesByDate(int latest) {
    System.out.println("Método no implementado.");
    return null;
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    return (List<EmployeeDto>) TcpServiceLocator.findEmployeesByDepartmentCode(departmentCode);
  }
}
