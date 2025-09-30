package pro.sky.employeeservice.model;

import ch.qos.logback.core.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class EmployeeId {
    private final String name;
    private final String surname;

    public EmployeeId(String name, String surname) {
        this.name = StringUtils.capitalize(StringUtils.lowerCase(name));
        this.surname = StringUtils.capitalize(StringUtils.lowerCase(surname));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeId that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
