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
public class Route {

    /* Attributes */
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long routeId;
    private String color, style, grade, status;

    /* JPA Relationships */
    @ManyToOne
    @JoinColumn(name = "gymId")
    private Gym gym;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    List<Execution> executions;

    public Route() {}

    /* Constructors */
    public Route(String color, String style, String grade, String status, Gym gym) {
        super();
        this.color = color;
        this.style = style;
        this.grade = grade;
        this.status = status;
        this.gym = gym;
    }

    /* Getters */
    public Long getRouteId() {
        return routeId;
    }

    public String getColor() {
        return color;
    }

    public String getStyle() {
        return style;
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
    
    public List<Execution> getExecutions() {
        return executions;
    }

    /* Setters */
    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    @Override
    public String toString() {
       
        if(this.gym != null)
            return "Route [routeId=" + routeId + ", color=" + color + ", style=" + style + ", grade=" + grade + ", status="
                    + status + ", gym=" + gym + "]";
        else
            return "Route [routeId=" + routeId + ", color=" + color + ", style=" + style + ", grade=" + grade + ", status="
                    + status + "]";
    }



}
