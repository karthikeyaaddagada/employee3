package employeecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import employeecompany.entity.Company;
import employeecompany.entity.Location;
import employeecompany.services.LocationService;





@RestController
public class LocationController
{
	@Autowired
	private LocationService locationService;
	
	
	@RequestMapping("/company/{Cid}/location")
    public List<Location> getAllLocation(@PathVariable int Cid)
    {
    	return locationService.getAllLocation(Cid);
    }
	@RequestMapping("/company/{companyId}/location/{Lid}")
    public Location getLocation(@PathVariable int Lid) 
    {
    	return locationService.getLocation(Lid);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/company/{companyCid}/location")
	public void addLocation(@RequestBody Location location, @PathVariable("companyCid") int Cid)
	{
		location.setCompany(new Company(Cid));
	     locationService.addLocation(location);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/company/{companyCid}/location/{Lid}")
	public void updateLocation(@RequestBody Location location, @PathVariable("companyCid") int Cid, @PathVariable("Lid") int Lid)
	{
 		location.setCompany(new Company(Cid));
	     locationService.updateLocation(location);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/company/{companyCid}/location/{Lid}")
    public void deleteLocation(@PathVariable int Lid) 
    {
    	locationService.deleteLocation(Lid);
    }
	
	
}

