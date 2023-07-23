package title8.application.employee.infrastructure.repository.facade;

import java.util.ArrayList;
import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.mapper.EmployeeMapper;
import title8.application.employee.infrastructure.repository.webservice.EmployeeRMIConnectorService;
import title8.application.employee.infrastructure.resource.webservice.rmi.EmployeeRemoteObject;
import title8.application.infrastructure.constant.RMIRemoteObjectConstant;

public class EmployeeFacadeRMI implements EmployeeFacade {

  public EmployeeRemoteObject employeeRemoteObject;

  public EmployeeFacadeRMI() {
    employeeRemoteObject = (EmployeeRemoteObject) EmployeeRMIConnectorService.getRemoteObject(RMIRemoteObjectConstant.EMPLOYEE);
  }

  @Override
  public List<EmployeeDto> findLatestEmployees(int latest) {
    System.out.println("No implementado.");
    return null;
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    try {
      List<String> employeeListToString = employeeRemoteObject.findByDepartmentCode(departmentCode);
      List<EmployeeDto> employeeList = new ArrayList<>();

      for (String actualEmployee : employeeListToString) {
        employeeList.add(EmployeeMapper.stringToEmployee(actualEmployee));
      }
      return employeeList;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}