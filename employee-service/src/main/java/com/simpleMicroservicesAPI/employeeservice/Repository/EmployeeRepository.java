package com.simpleMicroservicesAPI.employeeservice.Repository;

import com.simpleMicroservicesAPI.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByEmail(String email);
}
