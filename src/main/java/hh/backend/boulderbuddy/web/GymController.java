package hh.backend.boulderbuddy.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.backend.boulderbuddy.domain.Boulder;
import hh.backend.boulderbuddy.domain.BoulderRepository;
import hh.backend.boulderbuddy.domain.Gym;
import hh.backend.boulderbuddy.domain.GymRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * GymController Request Endpoints:
 * 
 * Login/logout: http://localhost:8080/login
 * Gymlist: http://localhost:8080/gyms
 * Add Gym: http://localhost:8080/addgym
 */

@Controller 
public class GymController {

    private final GymRepository gymRepository;
    private final BoulderRepository boulderRepository;
    
    public GymController(GymRepository gRepository,BoulderRepository bRepository) {

        this.gymRepository = gRepository;
        this.boulderRepository = bRepository;
    
    }

    /* All */
    @GetMapping("/gyms")
    public String gymList(Model model) {
        model.addAttribute("gyms", gymRepository.findAll());
        return "gymlist"; /* HTML */
    }
    
    /* Log */
    @GetMapping("/addgym") /* Request endpoint */
    @PreAuthorize("hasAuthority('ADMIN')") /* Authorized for 'ADMIN' -role */
    public String addGym(Model model) {
        model.addAttribute("gym", new Gym());
        model.addAttribute("boulders", boulderRepository.findAll());
        /* return "addlog"; */ /* HTML */
        return "addgym"; /* HTML */
    }

    /* Edit */
    @GetMapping("editgym/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")  /* Authorized for 'ADMIN' -role */
    public String editLog(@PathVariable("id") Long gymId, Model model) {
        model.addAttribute("gym", gymRepository.findById(gymId));
        model.addAttribute("boulders", boulderRepository.findAll());
        return "editgym";
    }  

    /* Save */
    @PostMapping("/savegym")
    @PreAuthorize("hasAuthority('ADMIN')") /* Authorized for 'ADMIN' -role */
    public String saveLog(Gym gym) {
        gymRepository.save(gym);
        return "redirect:/gymlist";
    }

    /* Delete */
    @GetMapping("deletegym/{id}")
    @PreAuthorize("hasAuthority('ADMIN')") /* Authorized for 'ADMIN' -role */
    public String deleteLog(@PathVariable("id") Long gymId, Model model) {
        gymRepository.deleteById(gymId);
        return "redirect:/gymlist";
    } 

    
}