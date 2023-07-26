package title8.application.department.application.service;

import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.repository.DepartmentRepository;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<DepartmentDto> findAll() {
    return departmentRepository.findAll();
  }
}
