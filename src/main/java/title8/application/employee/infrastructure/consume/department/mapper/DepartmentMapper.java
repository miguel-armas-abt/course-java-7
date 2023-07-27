package title8.application.employee.infrastructure.consume.department.mapper;

import java.util.StringTokenizer;
import title8.application.department.domain.model.DepartmentDto;

public class DepartmentMapper {

  public static DepartmentDto stringToDepartment(String departmentToString){
    DepartmentDto department = new DepartmentDto();

    StringTokenizer token = new StringTokenizer(departmentToString,",");
    department.setCode(Integer.parseInt(token.nextToken()));
    department.setName(token.nextToken());
    department.setLocation(token.nextToken());
    return department;
  }
}
