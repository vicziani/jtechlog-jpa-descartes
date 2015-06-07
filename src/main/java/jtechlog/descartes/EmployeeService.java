package jtechlog.descartes;

import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployees();

    Employee findEmployeeById(long id);
}
