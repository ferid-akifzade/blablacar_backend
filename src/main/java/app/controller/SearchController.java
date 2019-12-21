package app.controller;

import app.libs.History;
import app.libs.Ride;
import app.service.ReservationService;
import app.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;
    private final ReservationService reservationService;
    public SearchController(SearchService searchService, ReservationService reservationService) {

        this.searchService = searchService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Ride> getAdd() {
        return searchService.getAll();
    }

    @PostMapping
    public Object postsearch(
            @RequestParam("departure") String departure,
            @RequestParam("destination") String destination,
            @RequestParam("date") String date,
            @RequestParam("numseats") String numseats) {
        try {
            return searchService.findAll(departure, destination, date, Integer.parseInt(numseats));
        } catch (Exception e) {
            return "index";

        }
    }
    @GetMapping("/{id}")
    public Object reservation(@RequestParam("button") int button, @RequestParam("seats") int seats, @PathVariable("id") int clientID){
        Optional<History> reservation = reservationService.reservation(button, seats, clientID);
        if (reservation.isPresent())
            return reservation.get();
        return "index";
    }
}
