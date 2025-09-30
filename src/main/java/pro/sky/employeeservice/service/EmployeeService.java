package pro.sky.employeeservice.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeservice.exception.EmployeeAlreadyAddedException;
import pro.sky.employeeservice.exception.EmployeeNamingException;
import pro.sky.employeeservice.exception.EmployeeNotFoundException;
import pro.sky.employeeservice.exception.EmployeeStorageIsFullException;
import pro.sky.employeeservice.model.Employee;
import pro.sky.employeeservice.model.EmployeeId;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

@Service
public class EmployeeService {
    private Map<EmployeeId, Employee> employees;
    private int maxSize;

    public EmployeeService() {
        employees = new HashMap<EmployeeId, Employee>();
        maxSize = 10;
        Employee arr[] = {
                new Employee("A", "X", 1, 500),
                new Employee("B", "Y", 1, 1500),
                new Employee("C", "Z", 1, 500),
                new Employee("D", "W", 2, 5000),
        };
        for (Employee employee : arr) {
            employees.put(employee.getId(), employee);
        }
    }

    private boolean checkNameAndSurname(String name, String surname) {
        return name != null && StringUtils.isAlpha(name) &&
                surname != null && StringUtils.isAlpha(surname);
    }

    private String normalizeName(String name) {
        return StringUtils.capitalize(StringUtils.lowerCase(name));
    }

    public Collection<Employee> getAll() {
        return List.copyOf(employees.values());
    }

    public Employee addEmployee(String name, String surname) {
        if (!checkNameAndSurname(name, surname)) {
            throw new EmployeeNamingException();
        }
        name = normalizeName(name);
        surname = normalizeName(surname);
        if (employees.size() >= maxSize) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(name, surname);
        EmployeeId employeeId = employee.getId();
        if (employees.containsKey(employeeId)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employeeId, employee);
        return employees.get(employeeId);
    }

    public Employee findEmployee(String name, String surname) {
        if (!checkNameAndSurname(name, surname)) {
            throw new EmployeeNamingException();
        }
        name = normalizeName(name);
        surname = normalizeName(surname);
        EmployeeId employeeId = new EmployeeId(name, surname);
        if (!employees.containsKey(employeeId)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employeeId);
    }

    public Employee removeEmployee(String name, String surname) {
        if (!checkNameAndSurname(name, surname)) {
            throw new EmployeeNamingException();
        }
        name = normalizeName(name);
        surname = normalizeName(surname);
        EmployeeId employeeId = new EmployeeId(name, surname);
        if (!employees.containsKey(employeeId)) {
            throw new EmployeeNotFoundException();
        }
        Employee removedEmployee = employees.remove(employeeId);
        return removedEmployee;
    }

    public Employee setDepartmentForEmployee(String name, String surname, Integer departmentId) {
        if (!checkNameAndSurname(name, surname)) {
            throw new EmployeeNamingException();
        }
        name = normalizeName(name);
        surname = normalizeName(surname);
        EmployeeId employeeId = new EmployeeId(name, surname);
        if (!employees.containsKey(employeeId)) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.get(employeeId);
        employee.setOtdel(departmentId);
        return employee;
    }
}
