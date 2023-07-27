package title8.application.department.infrastructure.expose.webservice.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import title8.application.department.application.service.DepartmentService;
import title8.application.department.application.service.DepartmentServiceImpl;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.consume.repository.DepartmentRepositoryImpl;

public class DepartmentRemoteObjectImpl extends UnicastRemoteObject implements DepartmentRemoteObject {

  public DepartmentRemoteObjectImpl() throws RemoteException {
    super();
  }

  @Override
  public List<String> findAll() throws RemoteException {
    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
    List<DepartmentDto> departmentList = departmentService.findAll();

    List<String> departmentListToString = new ArrayList<>();
    for(DepartmentDto department: departmentList)
      departmentListToString.add(department.toString());

    return departmentListToString;
  }

  @Override
  public String findByCode(int code) throws RemoteException {
    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
    DepartmentDto department = departmentService.findByCode(code);
    return department.toString();
  }
}
