package jtechlog.descartes;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findEmployees();

    public Employee findEmployeeById(long id);
}
