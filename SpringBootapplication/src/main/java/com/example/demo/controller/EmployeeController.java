package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping 
	public Employee saveEmp(@RequestBody Employee employee) {
		return employeeRepository.save(employee);			
	}
	
	@PutMapping 
	public Employee updateEmp(@RequestBody Employee employee) {
		return employeeRepository.save(employee);			
	}
	@DeleteMapping 
	public String deleteEmp(@RequestParam Integer empId) {
		 employeeRepository.deleteById(empId);
		 return "Deleted successfully";
	}
	@GetMapping("/fetchall")
	public List<Employee> getAllEmps() {
		return employeeRepository.findAll();	
		
	}	
	@GetMapping("/{empId}")
	public Optional<Employee> getAllEmps(@PathVariable Integer empId) {
		
		return employeeRepository.findById(empId);	
		
	}
	@GetMapping("/by-name")
	public Employee findByEmpName(@RequestParam String empName) {
		
		return employeeRepository.findByEmpName(empName);	
		
	}
	@GetMapping("/by-salary")
	public List<Employee> findByEmpsSalary(@RequestParam Integer empSalary) {
		
		return employeeRepository.findByEmpSalary(empSalary);	
		
	}
	@GetMapping("/by-name-salary")
	public List<Employee> getEmpsByNameAndEmpSalary(@RequestParam String empName ,@RequestParam Integer empSalary) {
		
		return employeeRepository.findByEmpNameAndEmpSalary(empName,empSalary);	
	}
	
	@GetMapping("/by-distinct-name")
	public Employee getEmpByDistinctName(@RequestParam String empName ) {
		
		return employeeRepository.findDistinctByEmpName(empName);	
		
	}
}


