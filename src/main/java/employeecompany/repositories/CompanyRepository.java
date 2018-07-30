package employeecompany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import employeecompany.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer>
{

}