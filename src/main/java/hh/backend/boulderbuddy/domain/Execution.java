package hh.backend.boulderbuddy.domain;

import jakarta.persistence.Entity;

@Entity 
public class Execution {

    /* Attributes */
    private Long executionId;
    private int count, tries;
    private String status, effort;

    private Route route;
    private Session session;

    public Execution() {}

    /* Constructors */
    public Execution(int count, int tries, String status, String effort, Route route, Session session) {
        super();
        this.count = count;
        this.tries = tries;
        this.status = status;
        this.effort = effort;
        this.route = route;
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

    public Route getRoute() {
        return route;
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

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    /* toString */
    @Override
    public String toString() {
        return "Execution [executionId=" + executionId + ", count=" + count + ", tries=" + tries + ", status=" + status
                + ", effort=" + effort + ", route=" + route + ", session=" + session + "]";
    }


}
