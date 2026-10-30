package hh.backend.boulderbuddy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Route {

    @Id
    @GeneratedValue

    //Attributes
    /* private Long routeId; */
    private String color, style, grade, status/* ,Gym gym */;

}
