package employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void findEmployees() {
        var employees = employeeService.findEmployees();
        assertEquals(2, employees.size());
    }

    @Test
    public void findEmployeeById() {
        var employee = employeeService.findEmployeeById(1);

        assertEquals("John Doe", employee.getName());
        assertThat(employee.getAddresses())
                .extracting(Address::getCity)
                        .containsExactlyInAnyOrder("Budapest", "Békéscsaba");

        assertThat(employee.getPhones())
                .extracting(Phone::getNumber)
                        .containsExactlyInAnyOrder("111111", "222222");
    }
}
