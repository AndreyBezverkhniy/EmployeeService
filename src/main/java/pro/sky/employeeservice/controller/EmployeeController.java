package pro.sky.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Employee addEmployee(@RequestParam(name = "name") String name,
                                @RequestParam(name = "surname") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "surname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam(name = "name") String name,
                                   @RequestParam(name = "surname") String surname) {
        return employeeService.removeEmployee(name, surname);
    }
}
