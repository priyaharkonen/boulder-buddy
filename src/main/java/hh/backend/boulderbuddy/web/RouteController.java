package hh.backend.boulderbuddy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.backend.boulderbuddy.domain.GymRepository;
import hh.backend.boulderbuddy.domain.RouteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class RouteController {

    private final RouteRepository routeRepository;
    private final GymRepository gRepository;
    
    public RouteController(RouteRepository routeRepository, GymRepository gRepository) {
        
        this.routeRepository = routeRepository;
        this.gRepository = gRepository;
   
    }

    /* Routelist */
    @GetMapping("/routes")
    public String routeList(Model model) {
        model.addAttribute("routes", routeRepository.findAll());
        return "routelist";
    }
    




}
