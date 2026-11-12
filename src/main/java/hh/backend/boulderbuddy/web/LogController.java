package hh.backend.boulderbuddy.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.boulderbuddy.domain.Boulder;
import hh.backend.boulderbuddy.domain.BoulderRepository;
import hh.backend.boulderbuddy.domain.GymRepository;
import hh.backend.boulderbuddy.domain.Log;
import hh.backend.boulderbuddy.domain.LogRepository;

@Controller 
public class LogController {
    
    private final LogRepository logRepository;
    private final BoulderRepository boulderRepository;

    
    public LogController(LogRepository lRepository, BoulderRepository bRepository) {
        
        this.boulderRepository = bRepository;
        this.logRepository = lRepository;
   
    }
    
    /* All */
    @GetMapping("/logbook") /* Request endpoint */
    public String boulderList(Model model) {
        model.addAttribute("logs", logRepository.findAll());
        return "logbook"; /* HTML */
    }

    /* Log */
    @GetMapping("/addlog") /* Request endpoint */
    @PreAuthorize("hasAuthority('USER')") /* Authorized for 'USER' -role */
    public String addBoulder(Model model) {
        model.addAttribute("log", new Log());
        model.addAttribute("boulders", boulderRepository.findAll());
        return "addlog"; /* HTML */
        /* return "add"; /* HTML */ 
    }

    @PostMapping("/savelog")
    @PreAuthorize("hasAuthority('USER')") /* Authorized for 'USER' -role */
    public String saveLog(Log log) {
        logRepository.save(log);
        return "redirect:/logbook";
    }

    /* @GetMapping("delete/{id}") */
    @GetMapping("deleteLog/{id}")
    @PreAuthorize("hasAuthority('USER')")  /* Authorized for 'USER' -role */
    public String deleteLog(@PathVariable("id") Long logId, Model model) {
        logRepository.deleteById(logId);
        return "redirect:/logbook";
    }  

    
}


