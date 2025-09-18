package pro.sky.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeservice.model.Employee;
import pro.sky.employeeservice.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public Employee addEmployee(@PathVariable(name = "name") String name,
                                @PathVariable(name = "surname") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@PathVariable(name = "name") String name,
                                 @PathVariable(name = "surname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@PathVariable(name = "name") String name,
                                   @PathVariable(name = "surname") String surname) {
        return employeeService.removeEmployee(name, surname);
    }
}
