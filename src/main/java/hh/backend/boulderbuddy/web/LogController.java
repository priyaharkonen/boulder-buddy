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
    
    
}


