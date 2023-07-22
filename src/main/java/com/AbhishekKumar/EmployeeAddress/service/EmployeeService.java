package com.AbhishekKumar.EmployeeAddress.service;

import com.AbhishekKumar.EmployeeAddress.repository.IEmployeeRepo;
import com.AbhishekKumar.EmployeeAddress.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long empId) {

        return employeeRepo.findByEmployeeId(empId);
    }

    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee Added";
    }

    public String updateEmployeeById(Long empId,String fN,String lN) {
        Employee myEmployee;
        if(employeeRepo.existsById(empId)){
            myEmployee = employeeRepo.findByEmployeeId(empId);
            myEmployee.setEmployeeFirstName(fN);
            myEmployee.setEmployeeLastName(lN);
            employeeRepo.save(myEmployee);
            return "employee details updated";
        }
        return "no such employee exist!!";
    }

    public String deleteEmployeeById(Long empId) {
        if (employeeRepo.existsById(empId)) {
            employeeRepo.deleteById(empId);
            return "employee deleted";
        }
        return "no such employee exist!!";
    }
}