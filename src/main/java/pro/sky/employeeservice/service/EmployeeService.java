package pro.sky.employeeservice.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeservice.exception.EmployeeAlreadyAddedException;
import pro.sky.employeeservice.exception.EmployeeNotFoundException;
import pro.sky.employeeservice.exception.EmployeeStorageIsFullException;
import pro.sky.employeeservice.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;
    private int maxSize;

    public EmployeeService() {
        employees = new ArrayList<Employee>();
        maxSize = 3;
    }

    public Collection<Employee> getAll() {
        return List.copyOf(employees);
    }

    public Employee addEmployee(String name, String surname) {
        if (employees.size() >= maxSize) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employees.get(employees.indexOf(employee));
    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employees.indexOf(employee));
    }

    public Employee removeEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        Employee removedEmployee = employees.get(employees.indexOf(employee));
        employees.remove(employee);
        return removedEmployee;
    }
}
