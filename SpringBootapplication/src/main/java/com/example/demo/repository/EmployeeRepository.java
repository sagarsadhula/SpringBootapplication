package com.example.demo.repository;import java.util.List;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;import com.example.demo.entity.Employee;@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {		Employee findByEmpName(String empName);	List<Employee> findByEmpSalary(Integer empSalary);	List<Employee> findByEmpNameAndEmpSalary(String empName, Integer empSalary);	Employee findDistinctByEmpName(String empName);				}


