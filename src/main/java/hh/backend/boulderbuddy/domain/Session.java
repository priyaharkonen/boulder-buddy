package hh.backend.boulderbuddy.domain;

import java.time.LocalDate;
import java.time.LocalTime;
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
public class Session {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sessionId;
    private String title;
    private LocalDate date;
    private LocalTime startTime, duration;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "execution")
    private List<Execution> executions;
    
    @ManyToOne
    @JoinColumn(name = "gymId")
    private Gym gym;

    public Session() {}

    /* Constructors */
    public Session(String title, LocalDate date, LocalTime startTime, LocalTime duration, Gym gym) {
        super();
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.duration = duration;
        this.gym = gym;
    }

    /* Getters */
    public Long getSessionId() {
        return sessionId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public Gym getGym() {
        return gym;
    }

    public List<Execution> getExecutions() {
        return executions;
    }

    /* Setters */
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    @Override
    public String toString() {
        
        if (this.gym != null)
            return "Session [sessionId=" + sessionId + ", title=" + title + ", date=" + date + ", startTime=" + startTime
                    + ", duration=" + duration + ", gym=" + gym + "]";
        else
            return "Session [sessionId=" + sessionId + ", title=" + title + ", date=" + date + ", startTime=" + startTime
                    + ", duration=" + duration + "]";
    }
    

}
