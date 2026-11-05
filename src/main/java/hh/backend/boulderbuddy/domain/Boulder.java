package hh.backend.boulderbuddy.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity 
public class Boulder {

    /* Attributes */
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boulderId;
    private String color, wall, holds, grade, status;

    /* JPA Relationships */
    @ManyToOne
    @JoinColumn(name = "gymId")
    private Gym gym;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boulder")
    private List<Log> logs;

    public Boulder() {}

    /* Constructors */
    public Boulder(String color, String wall, String holds, String grade, String status, Gym gym) {
        super();
        this.color = color;
        this.wall = wall;
        this.holds = holds;
        this.grade = grade;
        this.status = status;
        this.gym = gym;
    }
    
    /* Getters */
    public Long getBoulderId() {
        return boulderId;
    }


    public String getColor() {
        return color;
    }

    public String getWall() {
        return wall;
    }

    public String getHolds() {
        return holds;
    }

    public String getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }

    public Gym getGym() {
        return gym;
    }
    
    public List<Log> getLogs() {
        return logs;
    }

    /* Setters */
    public void setBoulderId(Long routeId) {
        this.boulderId = routeId;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setHolds(String holds) {
        this.holds = holds;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
       
        if(this.gym != null)
            return "Boulder [boulderId=" + boulderId + ", color=" + color + ", wall=" + wall + ", holds=" + holds + ", grade="
                + grade + ", status=" + status + ", gym=" + gym + "]";
        else
            return "Boulder [boulderId=" + boulderId + ", color=" + color + ", wall=" + wall + ", holds=" + holds + ", grade="
                + grade + ", status=" + status + "]";
    }


}
