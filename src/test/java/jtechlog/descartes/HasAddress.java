package jtechlog.descartes;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class HasAddress extends TypeSafeDiagnosingMatcher<Employee> {

    private String city;

    private String addressLine1;

    @Factory
    public static HasAddress hasAddress(String city, String addressLine1) {
        return new HasAddress(city, addressLine1);
    }

    public HasAddress(String city, String addressLine1) {
        this.city = city;
        this.addressLine1 = addressLine1;
    }

    @Override
    protected boolean matchesSafely(Employee employee, Description description) {
        for (Address address: employee.getAddresses()) {
            if (city.equals(address.getCity()) && addressLine1.equals(address.getAddressLine1())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" employee with address city ")
                .appendValue(city)
                .appendText(" and address line 1 ")
                .appendValue(addressLine1);
    }
}
