package employeecompany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int eid;
    private String name;
    public String lastName;
    private String details;
    public double salary;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Location location;
    public Location getLocation()
    {
    	return location;
    }
    public void setLocation(Location location)
    {
    	this.location = location;
    }
  
    
    public Employee()
    {
    	
    }
    public Employee(int eid, String name, String lastName, String details, double salary, int Lid)
    {
    	super();
    	this.eid = eid;
    	this.name = name;
    	this.lastName = lastName;
    	this.details = details;
    	this.salary = salary;
		this.location= new Location();
		location.setLid(Lid);
    }
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}    
 
}
