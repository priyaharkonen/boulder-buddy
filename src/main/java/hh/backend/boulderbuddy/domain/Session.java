package hh.backend.boulderbuddy.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;

@Entity 
public class Session {

    /* Attributes */
    private Long sessionId;
    private String title;
    private LocalDate date;
    private LocalTime startTime, duration;

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
