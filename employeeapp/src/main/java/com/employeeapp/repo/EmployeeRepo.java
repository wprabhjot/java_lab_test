package com.employeeapp.repo;

import com.employeeapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	@Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.dname IN (:dname)")
	List<Employee> findByDepartmentDname(String dname);
	@Query(" SELECT e FROM Employee e JOIN FETCH e.department d  WHERE d.did IN (:did) ")
	List<Employee> findByDepartmentDid(int did);
	
	@Query("SELECT DISTINCT e FROM Employee e JOIN FETCH e.department")
	List<Employee> findAll();
}
