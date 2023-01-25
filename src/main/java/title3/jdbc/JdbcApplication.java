package title3.jdbc;

import title3.jdbc.dao.EmployeeDao;
import title3.jdbc.dao.impl.EmployeeDaoImpl;
import title4.application.employee.model.EmployeeDto;

import java.sql.Date;
import java.sql.SQLException;

public class JdbcApplication {

  public static void main(String[] args) throws SQLException {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    System.out.println("\nFIND BY CODE");
//    System.out.println(employeeDao.findByCode(2));

    System.out.println("\nFIND ALL");
    employeeDao.findAll().forEach(System.out::println);

    System.out.println("\nSAVE");
    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setName("Miguel");
    employeeDto.setDocumentIdentification(76517368);
    employeeDto.setContractDate(new Date(System.currentTimeMillis()));
    employeeDto.setContractType("planilla");
    employeeDto.setDepartmentCode(1);
    employeeDao.save(employeeDto);

    System.out.println("\nFIND ALL");
    employeeDao.findAll().forEach(System.out::println);

    System.out.println("\nDELETE BY ID");
    employeeDao.deleteByCode(7);

    System.out.println("\nFIND ALL");
    employeeDao.findAll().forEach(System.out::println);

  }
}
