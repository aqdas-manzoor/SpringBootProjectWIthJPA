package net.demo.projectjpa.employeesprintbootproject.repository;

import net.demo.projectjpa.employeesprintbootproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByName(String name);  // This returns Optional<Employee>

    @Query("SELECT e FROM Employee e WHERE e.age = :age")
    List<Employee> findByAge(@Param("age") int age);

}
