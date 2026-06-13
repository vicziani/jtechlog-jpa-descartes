package employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findEmployeeById(long id) {

//        return employeeRepository.findById(id).orElseThrow();
//        return employeeRepository.findEmployeeById(id);

        employeeRepository.findEmployeeByIdFetchPhones(id);
        return employeeRepository.findEmployeeByIdFetchAddresses(id);
    }

}
