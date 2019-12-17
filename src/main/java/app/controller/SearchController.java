package app.controller;

import app.libs.Ride;
import app.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
 @RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        
        this.searchService = searchService;
    }
     @GetMapping
     public String getAdd()
     {
         return "search";
     }
     @PostMapping
     public void postsearch(
             Model themodel,
             @RequestParam("departure") String departure,
             @RequestParam("destination") String destination,
             @RequestParam("date") String date,
             @RequestParam("numseats") String numseats)
     {
         try {
             List<Ride> allSeatchedRides = searchService.findAll(departure, destination, date, Integer.parseInt(numseats));
             themodel.addAttribute("Rides",allSeatchedRides);
         }
         catch (Exception e){
             themodel.addAttribute("Rides","No such ride ");
         }

     }
}
