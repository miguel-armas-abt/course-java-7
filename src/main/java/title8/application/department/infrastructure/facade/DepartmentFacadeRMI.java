package title8.application.department.infrastructure.facade;

import java.util.ArrayList;
import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.mapper.DepartmentMapper;
import title8.application.department.infrastructure.dao.DepartmentRMIDAO;
import title8.application.department.infrastructure.expose.webservice.rmi.DepartmentRemoteObject;
import title8.application.infrastructure.constant.RMIRemoteObjectConstant;

public class DepartmentFacadeRMI implements DepartmentFacade {

  public DepartmentRemoteObject departmentRemoteObject;

  public DepartmentFacadeRMI() {
    departmentRemoteObject = (DepartmentRemoteObject) DepartmentRMIDAO.getRemoteObject(RMIRemoteObjectConstant.DEPARTMENT);
  }

  @Override
  public List<DepartmentDto> findAll() {
    try {
      List<String> departmentListToString = departmentRemoteObject.findAll();
      List<DepartmentDto> departmentList = new ArrayList<>();

      for (String actualDepartment : departmentListToString) {
        departmentList.add(DepartmentMapper.stringToDepartment(actualDepartment));
      }
      return departmentList;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
