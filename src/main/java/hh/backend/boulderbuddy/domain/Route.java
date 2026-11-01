package hh.backend.boulderbuddy.domain;

import jakarta.persistence.Entity;


@Entity 
public class Route {

    /* Attributes */
    private Long routeId;
    private String color, style, grade, status;

    private Gym gym;

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
