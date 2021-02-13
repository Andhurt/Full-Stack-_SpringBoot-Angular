package com.huertas.fullStack.Service;

import com.huertas.fullStack.Repository.EmployeeRepository;
import com.huertas.fullStack.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    /**
     * Save the employee passed as parameter
     * @param employee
     * @return employee saved
     */
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    /**
     * Find all the employees in the database
     * @return the list of all employees in the databse.
     */
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    /**
     * Update the employee passed as parameter
     * @param employe
     * @return employee updated
     */
    public Employee updateEmployee(Employee employe){
        return employeeRepo.save(employe);
    }

    /**
     * Return the employee finded by ID passed as parameter
     * @param id of the employe to find.
     * @return employee with the id passed as parameter
     */
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                    .orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
    }

    /**
     * Delete an employee
     * @param idEmployee of the employee to delete.
     */
    public void deleteEmployee(Long idEmployee){
       employeeRepo.deleteEmployeeById(idEmployee);
    }

}
