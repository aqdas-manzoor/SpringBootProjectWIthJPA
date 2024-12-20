package net.demo.projectjpa.employeesprintbootproject.controller;

import net.demo.projectjpa.employeesprintbootproject.entity.Employee;
import net.demo.projectjpa.employeesprintbootproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")  // Base URL for all employee-related endpoints
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/name/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/age/{age}")
    public List<Employee> getEmployeesByAge(@PathVariable int age) {
        return employeeService.getEmployeesByAge(age);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}
