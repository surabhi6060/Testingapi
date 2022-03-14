package net.javaguides.springbootbackend.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRespository;
import net.javaguides.springbootbackend.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRespository employeeRepository;
	public EmployeeServiceImpl(EmployeeRespository employeeRespository) {
		super();
		this.employeeRepository = employeeRespository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> employee = employeeRepository.findById(id); 
		if(employee.isPresent())
		{
			return employee.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}

}
