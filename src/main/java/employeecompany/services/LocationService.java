package employeecompany.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import employeecompany.entity.Location;
import employeecompany.repositories.LocationRepository;

@Service
public class LocationService 
{

	@Autowired
	@Qualifier("locationRepository")
	private LocationRepository locationRepository;
	public List<Location> getAllLocation(int Cid)
	{
		List<Location> location = new ArrayList<>();
		locationRepository.findByCompanyCid(Cid)
		.forEach(location::add);
		return location;
	}
	public Location getLocation(int Lid)
	{
	    return locationRepository.findOne(Lid);
	}
	public void addLocation(Location location)
	{
	     locationRepository.save(location);
	}
	public void updateLocation(Location location)
	{
	    locationRepository.save(location);
    }
	public void deleteLocation(int Lid)
	{
		locationRepository.delete(Lid);
		
	}
}

