package employeecompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company 
{
	@Id
	@Column(name="Cid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String name;
		private String description;
	
	public Company() 
	{
            
	}
	
	public Company(int Cid, String name, String description) {
		super();
		this.cid = Cid;
		this.name = name;
		this.description = description;
	}
	public Company(int cid)
	{
		this.cid=cid;
	}
	
	
	public int getCid() 
	{
		return cid;
	}
	public void setCid(int Cid) 
	{
		this.cid = Cid;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	

}
