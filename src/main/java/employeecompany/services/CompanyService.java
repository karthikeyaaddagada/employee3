package employeecompany.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import employeecompany.entity.Company;
import employeecompany.repositories.CompanyRepository;

@Service
public class CompanyService 
{
	@Autowired
	@Qualifier("companyRepository")
	private CompanyRepository companyRepository;
	

	
	
	public List<Company> getAllCompany()
	{
		
		List<Company> company = new ArrayList();
		companyRepository.findAll()
		.forEach(company::add);
		return company;
	}
	
	public Company getCompany(int Cid)
	{
	    return companyRepository.findOne(Cid);
		
	}
	public void addCompany(Company company)
	{
		companyRepository.save(company);
	}

	public void updateCompany(int Cid, Company company)
	{
		company.setCid(Cid);
		System.out.println(company.getCid());
	companyRepository.save(company);
		
	
    }
	public void deleteCompany(int Cid)
	{
		companyRepository.delete(Cid);
	}
}
