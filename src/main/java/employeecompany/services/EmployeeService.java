package employeecompany.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import employeecompany.entity.Employee;
import employeecompany.repositories.EmployeeRepository;


@Service
public class EmployeeService
{

	@Autowired
	@Qualifier("employeeRepository")
	private EmployeeRepository employeeRepository;
	public List<Employee> getAllEmployee(int Lid)
	{
		List<Employee> employee = new ArrayList<>();
		employeeRepository.findByLocationLid(Lid)
		.forEach(employee::add);
		
	
		return employee;
	}
	public List<Employee> getAllEmployee(String lastName)
	{
		
		List<Employee> employee = new ArrayList<>();
		employeeRepository.findByLastName(lastName)
		.forEach(employee::add);
	    return employee;
	}
	public Employee getEmployee(int eid)
	{
	    return employeeRepository.findOne(eid);
	}
	public void addEmployee(Employee employee)
	{
	     employeeRepository.save(employee);
	}

	public void updateEmployee(Employee employee)
	{
	    employeeRepository.save(employee);
    }
	
	public void updateSalary(String lastName)
	{
		List<Employee> employeeList = employeeRepository.findByLastName(lastName);
		for(Employee employee : employeeList) {			
			double percent = (employee.getSalary()*5)/100;
			employee.setSalary(employee.getSalary() + percent); 
			employeeRepository.save(employee);
		}
		/*Employee employee = new Employee();
		employee.updateSalary("update employee set salary = salary+(salary*(5/100)) where lastName='smith'");
		employeeRepository.save(employee);*/
	}
	

	public void deleteEmployee(int eid)
	{
		employeeRepository.delete(eid);	
	}
	

}
