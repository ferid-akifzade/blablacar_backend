package app.controller;

import app.libs.History;
import app.service.ReservationService;
import app.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @GetMapping
    public Object getAdd() {
        return searchService.getAll();
    }

    @ResponseBody
    @PostMapping
    public Object postsearch(
            @RequestParam("departure") String departure,
            @RequestParam("destination") String destination,
            @RequestParam("date") String date) {
        try {
            return searchService.findAll(departure.trim(), destination.trim(), date.trim());
        } catch (Exception e) {
            return "search failed cant find ride with this credential ";

        }
    }

    @ResponseBody
    @PostMapping("/{id}")
    public Object reservation(@PathVariable("id") int rideId, @RequestParam("seats") int seats, @CookieValue("%ID%") int clientID) {
        Optional<History> reservation = reservationService.reservation(rideId, seats, clientID);
        if (reservation.isPresent())
            return reservation.get();
        return "reservation failed";
    }
}
