package title8.application2.server.rmi.remotefacade.impl;

import static title8.application2.util.constant.Constant.DEPARTMENT_DAO_CLASS;
import static title8.application2.util.constant.Constant.EMPLOYEE_DAO_CLASS;

import title8.application2.department.dao.DepartmentDao;
import title8.application2.department.model.DepartmentDto;
import title8.application2.employee.dao.EmployeeDao;
import title8.application2.employee.model.EmployeeDto;
import title8.application2.server.rmi.remotefacade.RemoteRmiFacade;
import title8.application2.util.Factory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteRmiFacadeImpl extends UnicastRemoteObject implements RemoteRmiFacade {

  public RemoteRmiFacadeImpl()throws RemoteException{
    super();
  }

  @Override
  public List<String> findByDepartmentCode(int departmentCode) throws RemoteException {
    EmployeeDao employeeDao = (EmployeeDao) Factory.build(EMPLOYEE_DAO_CLASS);
    List<EmployeeDto> employeeList = employeeDao.findByDepartmentCode(departmentCode);

    List<String> employeeListToString = new ArrayList<>();
    for(EmployeeDto employee: employeeList)
      employeeListToString.add(employee.toString());

    return employeeListToString;
  }

  @Override
  public List<String> findAll() throws RemoteException {
    DepartmentDao departmentDao = (DepartmentDao) Factory.build(DEPARTMENT_DAO_CLASS);
    List<DepartmentDto> departmentList = departmentDao.findAll();

    List<String> departmentListToString = new ArrayList<>();
    for(DepartmentDto department: departmentList)
      departmentListToString.add(department.toString());

    return departmentListToString;
  }
}
