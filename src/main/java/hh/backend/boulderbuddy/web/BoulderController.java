package hh.backend.boulderbuddy.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.backend.boulderbuddy.domain.GymRepository;
import hh.backend.boulderbuddy.domain.LogRepository;
import hh.backend.boulderbuddy.domain.Boulder;
import hh.backend.boulderbuddy.domain.BoulderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * BoulderController Request Endpoints:
 * 
 * Login/logout: http://localhost:8080/login
 * Boulderlist: http://localhost:8080/boulders
 * Log boulder: http://localhost:8080/log
 * Add boulder: http://localhost:8080/add
 */


@Controller 
public class BoulderController {

    private final BoulderRepository boulderRepository;
    private final LogRepository logRepository;
    private final GymRepository gymRepository;
    
    public BoulderController(BoulderRepository bRepository, GymRepository gRepository,LogRepository lRepository) {
        
        this.boulderRepository = bRepository;
        this.gymRepository = gRepository;
        this.logRepository = lRepository;
   
    }

    /* All */
    @GetMapping("/boulders") /* Request endpoint */
    public String boulderList(Model model) {
        model.addAttribute("boulders", boulderRepository.findAll());
        return "boulderlist"; /* HTML */
    }

    /* Add */
    @GetMapping("/add") /* Request endpoint */
    @PreAuthorize("hasAuthority('ADMIN')") /* Authorized for 'ADMIN' -role */
    public String addBoulder(Model model) {
        model.addAttribute("boulder", new Boulder());
        model.addAttribute("gyms", gymRepository.findAll());
        return "addboulder"; /* HTML */
        /* return "add"; /* HTML */ 
    }
    // /* Edit */
    // @GetMapping("edit/{id}")
    // @PreAuthorize("hasAuthority('ADMIN')")  /* Authorized for 'ADMIN' -role */
    // public String editBoulder(@PathVariable("id") Long boulderId, Model model) {
    //     model.addAttribute("boulder", boulderRepository.findById(boulderId));
    //     model.addAttribute("gyms", gymRepository.findAll());
    //     return "/edit";
    // }  

    /* Save */
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')") /* Authorized for 'ADMIN' -role */
    public String saveBoulder(Boulder boulder) {
        boulderRepository.save(boulder);
        return "redirect:/boulders";
    }

    /* Delete */
    @GetMapping("delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")  /* Authorized for 'ADMIN' -role */
    public String deleteBoulder(@PathVariable("id") Long boulderId, Model model) {
        boulderRepository.deleteById(boulderId);
        return "redirect:/boulders";
    }  

}
