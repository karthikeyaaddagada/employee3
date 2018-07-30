package employeecompany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Location 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	private String name;
	private String address;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;
	public Company getCompany() 
	{
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Location() 
	{

	}
	public Location(int  Lid, String name, String address,int Cid) {
		super();
		this.lid = Lid;
		this.name = name;
		this.address = address;
		this.company = new Company(Cid, "", "");
	}
	

	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
