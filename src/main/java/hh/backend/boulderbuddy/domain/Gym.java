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
    private String name;

    /* JPA Relationship */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Route> routes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Session> sessions;

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

    public List<Route> getRoutes() {
        return routes;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    /* Setters */
    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    /* toString */
    @Override
    public String toString() {
        return "Gym [gymId=" + gymId + ", name=" + name + "]";
    }    

}
