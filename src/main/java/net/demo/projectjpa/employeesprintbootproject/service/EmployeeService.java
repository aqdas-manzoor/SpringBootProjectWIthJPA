package net.demo.projectjpa.employeesprintbootproject.service;

import net.demo.projectjpa.employeesprintbootproject.entity.Employee;
import net.demo.projectjpa.employeesprintbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name).orElse(null);
    }

    public List<Employee> getEmployeesByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setEmail(employee.getEmail()) ;
        existingEmployee.setSalary(employee.getSalary() );
        // Save the updated entity
        return employeeRepository.save(existingEmployee);

    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
