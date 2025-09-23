package pro.sky.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private int otdel;
    private int salary;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.otdel = 0;
        this.salary = 0;
    }

    public Employee(String name, String surname, int otdel, int salary) {
        this.name = name;
        this.surname = surname;
        this.otdel = otdel;
        this.salary = salary;
    }

    public int getOtdel() {
        return otdel;
    }

    public void setOtdel(int otdel) {
        this.otdel = otdel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
        sb.append(", otdel=").append(otdel);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }

    @JsonIgnore
    public EmployeeId getId() {
        return new EmployeeId(name, surname);
    }
}
