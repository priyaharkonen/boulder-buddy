package hh.backend.boulderbuddy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Execution {

    /* Attributes */
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long executionId;
    private int count, tries;
    private String status, effort;

    /* JPA Relationships */
    @ManyToOne 
    @JoinColumn(name = "boulderId")
    private Boulder boulder;
    
    @ManyToOne 
    @JoinColumn(name = "sessionId")
    private Session session;

    public Execution() {}

    /* Constructors */
    public Execution(int count, int tries, String status, String effort, Boulder boulder, Session session) {
        super();
        this.count = count;
        this.tries = tries;
        this.status = status;
        this.effort = effort;
        this.boulder = boulder;
        this.session = session;
    }

    /* Getters */
    public Long getExecutionId() {
        return executionId;
    }

    public int getCount() {
        return count;
    }

    public int getTries() {
        return tries;
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

    public Session getSession() {
        return session;
    }

    /* Setters */
    public void setExecutionId(Long executionId) {
        this.executionId = executionId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTries(int tries) {
        this.tries = tries;
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

    public void setSession(Session session) {
        this.session = session;
    }


    /* toString */
    @Override
    public String toString() {
        return "Execution [executionId=" + executionId + ", count=" + count + ", tries=" + tries + ", status=" + status
                + ", effort=" + effort + ", route=" + boulder + ", session=" + session + "]";
    }


}
