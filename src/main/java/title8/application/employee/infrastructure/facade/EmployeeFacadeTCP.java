package title8.application.employee.infrastructure.facade;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.dao.EmployeeTCPDAO;

public class EmployeeFacadeTCP implements EmployeeFacade {

  @Override
  public List<EmployeeDto> findLatestEmployees(int latest) {
    System.out.println("Método no implementado.");
    return null;
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    return (List<EmployeeDto>) EmployeeTCPDAO.findEmployeesByDepartmentCode(departmentCode);
  }
}
