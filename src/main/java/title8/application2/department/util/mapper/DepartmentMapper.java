package title8.application2.department.util.mapper;

import title8.application2.department.model.DepartmentDto;

import java.util.StringTokenizer;

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
