package title8.application2.employee.util.mapper;

import title8.application2.employee.model.EmployeeDto;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class EmployeeMapper {

  public static EmployeeDto stringToEmployee(String employeeToString){
    EmployeeDto dto = new EmployeeDto();

    StringTokenizer token = new StringTokenizer(employeeToString,",");
    dto.setCode(Integer.parseInt(token.nextToken()));
    dto.setName(token.nextToken());

    String contractDate = token.nextToken();

    dto.setDepartmentCode(Integer.parseInt(token.nextToken().trim()));

    // proceso la cadena de date
    StringTokenizer date = new StringTokenizer(contractDate,"-");
    int year = Integer.parseInt(date.nextToken().trim());
    int month = Integer.parseInt(date.nextToken().trim());
    int day = Integer.parseInt(date.nextToken().trim());

    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.set(Calendar.YEAR,year);
    gregorianCalendar.set(Calendar.MONTH,month);
    gregorianCalendar.set(Calendar.DAY_OF_MONTH,day);

    dto.setContractDate(new Date(gregorianCalendar.getTimeInMillis()));
    return dto;
  }
}
