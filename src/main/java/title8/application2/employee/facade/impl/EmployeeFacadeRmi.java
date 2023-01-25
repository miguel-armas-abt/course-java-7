package title8.application2.employee.facade.impl;

import static title8.application2.util.constant.Constant.REMOTE_OBJECT;

import title8.application2.employee.facade.EmployeeFacade;
import title8.application2.employee.model.EmployeeDto;
import title8.application2.employee.util.mapper.EmployeeMapper;
import title8.application2.server.rmi.RmiServiceLocator;
import title8.application2.server.rmi.remotefacade.RemoteRmiFacade;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFacadeRmi implements EmployeeFacade {

  public RemoteRmiFacade remoteFacade;

  public EmployeeFacadeRmi() {
    remoteFacade = (RemoteRmiFacade) RmiServiceLocator.getObjetoRemoto(REMOTE_OBJECT);
  }

  @Override
  public List<EmployeeDto> findLatestEmployeesByDate(int latest) {
    System.out.println("No implementado.");
    return null;
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    try {
      List<String> employeeListToString = remoteFacade.findByDepartmentCode(departmentCode);
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
