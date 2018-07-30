package employeecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import employeecompany.entity.Company;
import employeecompany.services.CompanyService;


@RestController
public class CompanyController
{
	@Autowired
	private CompanyService companyService;
	
	
	@RequestMapping("/company")
    public List<Company> getAllCompany()
    {
    	return companyService.getAllCompany();
    }
	@RequestMapping("/company/{Cid}")
    public Company getCompany(@PathVariable int Cid) 
    {
    	return companyService.getCompany(Cid);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/company")
	public void addCompany(@RequestBody Company company)
	{
	     companyService.addCompany(company);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/company/{Cid}")
	public void updateCompany(@RequestBody Company company,@PathVariable int Cid)
	{
	     companyService.updateCompany(Cid, company);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/company/{Cid}")
    public void deleteCompany(@PathVariable int Cid) 
    {
    	companyService.deleteCompany(Cid);
    }
	
	
}
 