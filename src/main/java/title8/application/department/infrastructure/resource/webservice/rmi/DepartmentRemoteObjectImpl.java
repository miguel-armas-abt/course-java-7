package title8.application.department.infrastructure.resource.webservice.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.repository.database.DepartmentDao;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class DepartmentRemoteObjectImpl extends UnicastRemoteObject implements DepartmentRemoteObject {

  public DepartmentRemoteObjectImpl() throws RemoteException{
    super();
  }

  @Override
  public List<String> findAll() throws RemoteException {
    DepartmentDao departmentDao = (DepartmentDao) ObjectFactory.build(ClassesProperties.departmentDaoClass);
    List<DepartmentDto> departmentList = departmentDao.findAll();

    List<String> departmentListToString = new ArrayList<>();
    for(DepartmentDto department: departmentList)
      departmentListToString.add(department.toString());

    return departmentListToString;
  }
}
