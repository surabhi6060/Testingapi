package net.javaguides.springbootbackend.service;
import java.util.List;
import net.javaguides.springbootbackend.model.Employee;
public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	

}
