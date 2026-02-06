package com.employeeapp.controller;

import com.employeeapp.dto.DeptEmpResponse;
import com.employeeapp.entities.Employee;
import com.employeeapp.repo.DepartmentRepo;
import com.employeeapp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(path = "employees")
    public List<Employee> getAllEmp(){
        return employeeRepo.findAll();
    }

    @GetMapping(path = "employeesdata")
    public List<DeptEmpResponse> getAllEmpSelectedData(){
        return departmentRepo.deptEmployeeData();
    }

    @GetMapping(path="employees/{dname}")
    public List<Employee> findByDepartmentDname(@PathVariable String dname){
    	return employeeRepo.findByDepartmentDname(dname);
    }
    
    @GetMapping(path="employees/{did}")
    public List<Employee> findByDepartmentDid(@PathVariable int did){
    	return employeeRepo.findByDepartmentDid(did);
    }
}
