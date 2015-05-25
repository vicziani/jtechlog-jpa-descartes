package jtechlog.descartes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static jtechlog.descartes.HasAddress.hasAddress;
import static jtechlog.descartes.HasPhoneNumber.hasPhoneNumber;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-test.xml"})
public class EmployeeServiceIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testFindEmployees() {
        List<Employee> employees = employeeService.findEmployees();
        assertThat(2, equalTo(employees.size()));
    }

    @Test
    public void testFindEmployeeById() {
        Employee employee = employeeService.findEmployeeById(1);

        assertThat(employee.getName(), equalTo("John Doe"));
        assertThat(employee.getPhones(), hasSize(2));
        assertThat((employee), hasPhoneNumber("home", equalTo("111111")));
        assertThat(employee, hasPhoneNumber("office", equalTo("222222")));
        assertThat(2, equalTo(employee.getAddresses().size()));
        assertThat(employee, hasAddress("Budapest", "Arany János u. 1."));
        assertThat(employee, hasAddress("Békéscsaba", "Jókai u. 1."));
    }
}
