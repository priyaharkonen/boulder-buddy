package hh.backend.boulderbuddy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Gym {

    /* Attributes */
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gymId;
    private String name;

    public Gym() {}

    /* Constructors */
    public Gym(String name) {
        super();
        this.name = name;
    }

    /* Getters */
    public Long getGymId() {
        return gymId;
    }

    public String getName() {
        return name;
    }

    /* Setters */
    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* toString */
    @Override
    public String toString() {
        return "Gym [gymId=" + gymId + ", name=" + name + "]";
    }    

}
