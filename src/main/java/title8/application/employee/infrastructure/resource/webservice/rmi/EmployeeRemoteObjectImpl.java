package title8.application.employee.infrastructure.resource.webservice.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.repository.database.EmployeeDao;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class EmployeeRemoteObjectImpl extends UnicastRemoteObject implements EmployeeRemoteObject {

  public EmployeeRemoteObjectImpl() throws RemoteException{
    super();
  }

  @Override
  public List<String> findByDepartmentCode(int departmentCode) throws RemoteException {
    EmployeeDao employeeDao = (EmployeeDao) ObjectFactory.build(ClassesProperties.employeeDaoClass);
    List<EmployeeDto> employeeList = employeeDao.findByDepartmentCode(departmentCode);

    List<String> employeeListToString = new ArrayList<>();
    for(EmployeeDto employee: employeeList)
      employeeListToString.add(employee.toString());

    return employeeListToString;
  }
}
