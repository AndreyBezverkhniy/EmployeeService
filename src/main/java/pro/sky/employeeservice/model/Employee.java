package pro.sky.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String info;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.info = "NO INFO";
    }

    public Employee(String name, String surname, String info) {
        this.name = name;
        this.surname = surname;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", info='").append(info).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @JsonIgnore
    public EmployeeId getId() {
        return new EmployeeId(name, surname);
    }
}
