package pro.sky.employeeservice.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeservice.model.Employee;

import java.util.*;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Collection<Employee> getEmployeesWithMaxSalary(Integer departmentId) {
        Collection<Employee> employees=employeeService.getAll();
        int max = employees.stream()
                .filter(employee -> employee.getOtdel() == departmentId)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .get().getSalary();
        return employees.stream()
                .filter(employee -> employee.getOtdel() == departmentId)
                .filter(employee -> employee.getSalary() == max)
                .toList();
    }

    public Collection<Employee> getEmployeesWithMinSalary(Integer departmentId) {
        Collection<Employee> employees=employeeService.getAll();
        int min = employees.stream()
                .filter(employee -> employee.getOtdel() == departmentId)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .get().getSalary();
        return employees.stream()
                .filter(employee -> employee.getOtdel() == departmentId)
                .filter(employee -> employee.getSalary() == min)
                .toList();
    }

    public Collection<Employee> getEmployeesByDepartment(Integer departmentId) {
        Collection<Employee> employees=employeeService.getAll();
        return employees.stream()
                .filter(employee -> employee.getOtdel() == departmentId)
                .toList();
    }

    public Collection<Collection<Employee>> getEmployeesOfAllDepartments() {
        Map<Integer, Collection<Employee>> res = new HashMap<Integer, Collection<Employee>>();
        Collection<Employee> employees=employeeService.getAll();
        employees.stream()
                .forEach(employee ->
                        res.computeIfAbsent(employee.getOtdel(), ArrayList<Employee>::new)
                                .add(employee)
                );
        return res.values();
    }
}