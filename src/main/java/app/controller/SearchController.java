package app.controller;

import app.libs.Ride;
import app.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {

        this.searchService = searchService;
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
}
