package hh.backend.boulderbuddy.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Log {

    /* Attributes */
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long logId;
    private LocalDate date;
    private int tryCount;
    private String status, effort;

    /* JPA Relationships */
    @ManyToOne 
    @JoinColumn(name = "boulderId")
    private Boulder boulder;

    public Log() {}

    /* Constructors */
    public Log(LocalDate date, int tryCount, String status, String effort, Boulder boulder) {
        super();
        this.date = date;
        this.tryCount = tryCount;
        this.status = status;
        this.effort = effort;
        this.boulder = boulder;
    }

    /* Getters */
    public Long getLogId() {
        return logId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getStatus() {
        return status;
    }

    public String getEffort() {
        return effort;
    }

    public Boulder getBoulder() {
        return boulder;
    }

    /* Setters */
    public void setLogId(Long log) {
        this.logId = log;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }
    public void setBoulder(Boulder boulder) {
        this.boulder = boulder;
    }


    @Override
    public String toString() {
        return "Log [logId=" + logId + ", date=" + date + ", tryCount=" + tryCount + ", status=" + status
                + ", effort=" + effort + "]";
    }


}
