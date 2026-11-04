package hh.backend.boulderbuddy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.backend.boulderbuddy.domain.GymRepository;
import hh.backend.boulderbuddy.domain.BoulderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class BoulderController {

    private final BoulderRepository routeRepository;
    private final GymRepository gymRepository;
    
    public BoulderController(BoulderRepository rRepository, GymRepository gRepository) {
        
        this.routeRepository = rRepository;
        this.gymRepository = gRepository;
   
    }

    /* Routelist */
    @GetMapping("/boulders")
    public String routeList(Model model) {
        model.addAttribute("boulders", routeRepository.findAll());
        return "boulderlist";
    }
    

}
