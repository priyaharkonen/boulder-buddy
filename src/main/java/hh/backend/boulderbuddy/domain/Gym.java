package hh.backend.boulderbuddy.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Gym {

    /* Attributes */
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gymId;
    private String company, location, weekOpening, weekEndOpening;

    /* JPA Relationship */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Boulder> boulders;

    public Gym() {}

    /* Constructors */
    public Gym(String company, String location, String weekOpening, String weekEndOpening) {
        super();
        this.company = company;
        this.location = location;
        this.weekOpening = weekOpening;
        this.weekEndOpening = weekEndOpening;
    }

    /* Getters */
    public Long getGymId() {
        return gymId;
    }
    
    public String getCompany() {
        return company;
    }
    public String getLocation() {
        return location;
    }

    public String getWeekOpening() {
        return weekOpening;
    }

    public String getWeekEndOpening() {
        return weekEndOpening;
    }

    public List<Boulder> getBoulders() {
        return boulders;
    }

    /* Setters */
    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeekOpening(String weekOpening) {
        this.weekOpening = weekOpening;
    }

    public void setWeekEndOpening(String weekEndOpening) {
        this.weekEndOpening = weekEndOpening;
    }

    public void setBoulders(List<Boulder> boulders) {
        this.boulders = boulders;
    }

    /* toStrig()*/
    @Override
    public String toString() {
        return "Gym [gymId=" + gymId + ", company=" + company + ", location=" + location + ", weekOpening=" + weekOpening
                + ", weekEndOpening=" + weekEndOpening + "]";
    }    

}
