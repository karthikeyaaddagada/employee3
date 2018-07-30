package employeecompany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import employeecompany.entity.Location;

@Repository 
public interface LocationRepository extends CrudRepository<Location,Integer>
{
   public List<Location> findByCompanyCid(int Cid);
}

