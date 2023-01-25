package title8.application2.department.facade.impl;

import static title8.application2.util.constant.Constant.REMOTE_OBJECT;

import title8.application2.department.facade.DepartmentFacade;
import title8.application2.department.model.DepartmentDto;
import title8.application2.department.util.mapper.DepartmentMapper;
import title8.application2.server.rmi.RmiServiceLocator;
import title8.application2.server.rmi.remotefacade.RemoteRmiFacade;
import java.util.ArrayList;
import java.util.List;

public class DepartmentFacadeRmi implements DepartmentFacade {

  public RemoteRmiFacade remoteFacade;

  public DepartmentFacadeRmi() {
    remoteFacade = (RemoteRmiFacade) RmiServiceLocator.getObjetoRemoto(REMOTE_OBJECT);
  }

  @Override
  public List<DepartmentDto> findAll() {
    try {
      List<String> departmentListToString = remoteFacade.findAll();
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
