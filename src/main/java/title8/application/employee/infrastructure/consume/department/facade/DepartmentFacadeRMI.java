package title8.application.employee.infrastructure.consume.department.facade;

import java.util.ArrayList;
import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.employee.infrastructure.consume.department.mapper.DepartmentMapper;
import title8.application.employee.infrastructure.consume.department.dao.DepartmentRMIDAO;
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
    } catch (Exception exception) {
      throw new RuntimeException("error mapping the department list: " + exception.getMessage());
    }
  }

  @Override
  public DepartmentDto findByCode(int code) {
    try {
      return DepartmentMapper.stringToDepartment(departmentRemoteObject.findByCode(code));
    } catch (Exception exception) {
      throw new RuntimeException("error mapping the department by code: " + exception.getMessage());
    }
  }
}
