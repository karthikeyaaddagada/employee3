package employeecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import employeecompany.entity.Employee;
import employeecompany.entity.Location;
import employeecompany.services.EmployeeService;

@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("/employee/location/{Lid}")
    public List<Employee> getAllEmployee(@PathVariable int Lid)
    {
    	return employeeService.getAllEmployee(Lid);
    }
	@RequestMapping("/employee/{eid}")
    public Employee getEmployee(@PathVariable int eid) 
    {
    	return employeeService.getEmployee(eid);
    }
	@RequestMapping("/employee/lastName/{lastName}")
    public List<Employee> getAllEmployee(@PathVariable("lastName") String lastName) 
    {
    	return employeeService.getAllEmployee(lastName);
    }

	@RequestMapping(method=RequestMethod.PUT, value="/employee/salary/{lastName}")
	public void updateSalary(@PathVariable("lastName") String lastName) 
    {
	
		Employee employee = new Employee();
		employee.setLastName(lastName);		
    	employeeService.updateSalary(lastName);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/employee/location/{locationLid}")
	public void addEmployee(@RequestBody Employee employee, @PathVariable("locationLid") int Lid)
	{
		Location location = new Location();
		location.setLid(Lid);
		employee.setLocation(location);
	     employeeService.addEmployee(employee);	
	}
	@RequestMapping(method=RequestMethod.PUT, value="/employee/{eid}/location/{locationLid}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable("locationLid") int Lid, @PathVariable("eid") int eid)
	{
		Location location = new Location();
		location.setLid(Lid);
 		employee.setLocation(location);
	     employeeService.updateEmployee(employee);	
	}
	@RequestMapping(method=RequestMethod.DELETE, value ="/employee/{eid}/location/{locationLid}")
    public void deleteEmployee(@PathVariable int eid) 
    {
    	employeeService.deleteEmployee(eid);
    }
	
}

