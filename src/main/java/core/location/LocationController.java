package core.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/location") // This means URL's start with /demo (after Application path)
public class LocationController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private LocationRepository locationRepository;

    @GetMapping()
    public @ResponseBody Iterable<Location> getAllLocations() {
        // This returns a JSON or XML with the users
        return locationRepository.findAll();
    }

    @PostMapping () // Map ONLY POST Requests
    public @ResponseBody String addNewLocation (
            @RequestParam String PESEL,
            @RequestParam Integer addid) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Location n = new Location(PESEL, addid);

        // add citizen to repository
        locationRepository.save(n);

        return "Location added\n";
    }

    @PutMapping()
    public @ResponseBody String updateLocation(
            @RequestParam String PESEL,
            @RequestParam Integer addid) {

        Location locationReal = new Location(PESEL, addid);

        return locationRepository.findById(locationReal.getPESEL())
                .map(location -> {
                    location.setPESEL(locationReal.getPESEL());
                    location.setAddid(locationReal.getAddid());
                    locationRepository.save(location);
                    return "Location updated\n";
                })
                .orElseGet(() -> {
                    // add new citizen if not found
                    locationRepository.save(locationReal);
                    return "Location not found and added\n";
                });

    }

    @DeleteMapping()
    public @ResponseBody String deleteLocation(
            @RequestParam String PESEL) {

        locationRepository.deleteById(PESEL);

        return "Location for PESEL deleted\n";
    }

    @GetMapping(path="/stat")
    public @ResponseBody Long getAddressCount() {
        // This returns a JSON or XML with the users
        return locationRepository.count();
    }
}