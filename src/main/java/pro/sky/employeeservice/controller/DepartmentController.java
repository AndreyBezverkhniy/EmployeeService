package pro.sky.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeservice.model.Employee;
import pro.sky.employeeservice.service.DepartmentService;

import java.util.Collection;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Collection<Employee> getEmployeesWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeesWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Collection<Employee> getEmployeesWithMinxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeesWithMinSalary(departmentId);
    }

    @GetMapping("/by")
    public Collection<Employee> getEmployeesByDepartment(@RequestParam Integer departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Collection<Collection<Employee>> getEmployeesOfAllDepartments() {
        return departmentService.getEmployeesOfAllDepartments();
    }
}
