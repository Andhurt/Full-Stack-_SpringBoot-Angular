package com.huertas.fullStack.Repository;

import com.huertas.fullStack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long idEmployee);

    Optional findEmployeeById(Long id);
}
