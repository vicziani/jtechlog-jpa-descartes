package jtechlog.descartes;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.ArrayList;
import java.util.List;

public class HasPhoneNumber extends TypeSafeDiagnosingMatcher<Employee> {

    private String type;

    private Matcher<? super String> valueMatcher;

    @Factory
    public static HasPhoneNumber hasPhoneNumber(String type, Matcher<? super String> valueMatcher) {
        return new HasPhoneNumber(type, valueMatcher);
    }

    public HasPhoneNumber(String type, Matcher<? super String> valueMatcher) {
        this.type = type;
        this.valueMatcher = valueMatcher;
    }

    @Override
    protected boolean matchesSafely(Employee employee, Description description) {
        List<String> types = new ArrayList<>();
        for (Phone phone: employee.getPhones()) {
            if (type.equals(phone.getType()) ) {
                if (valueMatcher.matches(phone.getNumber())) {
                    return true;
                }
                else {
                    description.appendText(" phone number found: " + phone.getNumber());
                    return false;
                }
            }
            types.add(phone.getType());
        }
        description.appendText(" types found: ").appendValueList("[", ",", "]", types);
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" employee with phone type ")
                .appendValue(type)
                .appendText(" and number ")
                .appendDescriptionOf(valueMatcher);
    }
}
