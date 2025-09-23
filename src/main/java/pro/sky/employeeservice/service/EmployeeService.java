package pro.sky.employeeservice.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeservice.exception.EmployeeAlreadyAddedException;
import pro.sky.employeeservice.exception.EmployeeNotFoundException;
import pro.sky.employeeservice.exception.EmployeeStorageIsFullException;
import pro.sky.employeeservice.model.Employee;
import pro.sky.employeeservice.model.EmployeeId;

import java.util.*;
import java.util.stream.Collectors;

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

    public Collection<Employee> getAll() {
        return List.copyOf(employees.values());
    }

    public Employee addEmployee(String name, String surname) {
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
        EmployeeId employeeId = new EmployeeId(name, surname);
        if (!employees.containsKey(employeeId)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employeeId);
    }

    public Employee removeEmployee(String name, String surname) {
        EmployeeId employeeId = new EmployeeId(name, surname);
        if (!employees.containsKey(employeeId)) {
            throw new EmployeeNotFoundException();
        }
        Employee removedEmployee = employees.remove(employeeId);
        return removedEmployee;
    }

    public Employee setDepartmentForEmployee(String name, String surname, Integer departmentId) {
        EmployeeId employeeId = new EmployeeId(name, surname);
        if (!employees.containsKey(employeeId)) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.get(employeeId);
        employee.setOtdel(departmentId);
        return employee;
    }
}
