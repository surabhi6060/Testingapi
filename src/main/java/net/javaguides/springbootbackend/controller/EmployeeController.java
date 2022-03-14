package net.javaguides.springbootbackend.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootbackend.service.EmployeeService;
import net.javaguides.springbootbackend.model.Employee;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService)
	{
		super();
		this.employeeService = employeeService;
	}
	//build create employee Rest API
	@PostMapping()
	
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
}
	//build get all employee REST API
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	//build get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
}
