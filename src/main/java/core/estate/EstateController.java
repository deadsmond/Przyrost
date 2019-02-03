package core.estate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/estate") // This means URL's start with /demo (after Application path)
public class EstateController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private EstateRepository estateRepository;

    @GetMapping()
    public @ResponseBody Iterable<Estate> getAllEstates() {
        // This returns a JSON or XML with the users
        return estateRepository.findAll();
    }

    @PostMapping () // Map ONLY POST Requests
    public @ResponseBody String addNewEstate (
            @RequestParam String PESEL,
            @RequestParam Integer addid) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Estate n = new Estate(PESEL, addid);

        // add citizen to repository
        estateRepository.save(n);

        return "Estate added\n";
    }

    @PutMapping()
    public @ResponseBody String updateEstate(
            @RequestParam String PESEL,
            @RequestParam Integer addid) {

        Estate estateReal = new Estate(PESEL, addid);

        return estateRepository.findById(estateReal.getPESEL())
                .map(estate -> {
                    estate.setPESEL(estateReal.getPESEL());
                    estate.setAddid(estateReal.getAddid());
                    estateRepository.save(estate);
                    return "Estate updated\n";
                })
                .orElseGet(() -> {
                    // add new citizen if not found
                    estateRepository.save(estateReal);
                    return "Estate not found and added\n";
                });

    }

    @DeleteMapping()
    public @ResponseBody String deleteEstate(
            @RequestParam String PESEL) {

        estateRepository.deleteById(PESEL);

        return "Estate for PESEL deleted\n";
    }

    @GetMapping(path="/stat")
    public @ResponseBody Long getAddressCount() {
        // This returns a JSON or XML with the users
        return estateRepository.count();
    }
}