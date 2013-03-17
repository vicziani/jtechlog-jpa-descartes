package jtechlog.descartes;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

        assertThat("John Doe", equalTo(employee.getName()));
        assertThat(2, equalTo(employee.getPhones().size()));
        assertThat(employee.getPhones(), hasPhoneNumberWithType("home", "111111"));
        assertThat(employee.getPhones(), hasPhoneNumberWithType("office", "222222"));
        assertThat(2, equalTo(employee.getAddresses().size()));
        assertThat(employee.getAddresses(), hasAddress("Budapest", "Arany János u. 1."));
        assertThat(employee.getAddresses(), hasAddress("Békéscsaba", "Jókai u. 1."));
    }

    private Matcher<Iterable<Phone>> hasPhoneNumberWithType(final String type, final String number) {
        return new BaseMatcher<Iterable<Phone>>() {
            @Override
            @SuppressWarnings("unchecked")
            public boolean matches(Object o) {
                Iterable<Phone> phones = (Iterable<Phone>) o;
                for (Phone phone: phones) {
                    if (type.equals(phone.getType()) && number.equals(phone.getNumber())) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("must have ").appendValue(number).appendText(" number with type ").appendValue(type);
            }
        };
    }

    private Matcher<Iterable<Address>> hasAddress(final String city, final String addressLine1) {
        return new BaseMatcher<Iterable<Address>>() {
            @Override
            @SuppressWarnings("unchecked")
            public boolean matches(Object o) {
                Iterable<Address> addresses = (Iterable<Address>) o;
                for (Address address: addresses) {
                    if (city.equals(address.getCity()) && addressLine1.equals(address.getAddressLine1())) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("must have address with ").appendValue(city).appendText(" city")
                        .appendText(" and  ").appendValue(addressLine1).appendText(" address line 1");
            }
        };
    }
}
