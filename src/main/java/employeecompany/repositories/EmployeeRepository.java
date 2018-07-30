package employeecompany.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import employeecompany.entity.Employee;



@Repository 
public interface EmployeeRepository extends CrudRepository<Employee,Integer>
{
   public List<Employee> findByLocationLid(int Lid);
   public List<Employee> findByLastName(String lastName);
}

