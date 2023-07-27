package title8.application.department.application.service;

import java.util.List;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.consume.repository.DepartmentRepository;

public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<DepartmentDto> findAll() {
    return departmentRepository.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return departmentRepository.findByCode(code);
  }
}
