package hh.backend.boulderbuddy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.backend.boulderbuddy.domain.GymRepository;
import hh.backend.boulderbuddy.domain.BoulderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class BoulderController {

    private final BoulderRepository boulderRepository;
    private final GymRepository gymRepository;
    
    public BoulderController(BoulderRepository bRepository, GymRepository gRepository) {
        
        this.boulderRepository = bRepository;
        this.gymRepository = gRepository;
   
    }

    /* Boulderlist */
    @GetMapping("/boulders")
    public String boulderList(Model model) {
        model.addAttribute("boulders", boulderRepository.findAll());
        return "boulderlist";
    }
    

}
