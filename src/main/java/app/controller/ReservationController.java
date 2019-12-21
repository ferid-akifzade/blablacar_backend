package app.controller;

import app.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/search")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping
    public String reservation(@RequestParam("button") int button, @RequestParam("seats") int seats, @CookieValue("name = \"%ID%\", defaultValue = \"-1\"") int clientID){

        // reservation test
        if(reservationService.reservation(button,seats,clientID))
        return"redirect:/";

        return "redirect:/search";
    }
}
