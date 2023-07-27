package title8.application.employee.infrastructure.consume.department.repository;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;

public interface DepartmentRepository {

  List<DepartmentDto> findAll();

  DepartmentDto findByCode(int code);
}
