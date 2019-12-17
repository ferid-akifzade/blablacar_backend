package app.controller;

import app.libs.Ride;
import app.service.AddRideService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/add")
public class AddTripController {
    private final AddRideService addRideService;

    public AddTripController(AddRideService addRideService) {
        this.addRideService = addRideService;
    }

    @GetMapping
    public String getAdd()
    {
        return "addTrip";
    }

    @PostMapping
    public String postAdd(
            @RequestParam("from_place") String from,
            @RequestParam("to_place") String to,
            @RequestParam("comment") String comment,
            @RequestParam("date") String date,
            @RequestParam("price") int price,
            @CookieValue(name = "%ID%", defaultValue = "-1") int driver_id)
    {
        addRideService.add(new Ride(from,to,comment,date,price,driver_id));
        return "redirect:/";
    }
}
