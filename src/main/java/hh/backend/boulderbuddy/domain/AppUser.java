package hh.backend.boulderbuddy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "UserTable")
public class AppUser {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long userId;

    /* Username (unique) */
    @Column(name = "username", nullable = false, updatable = true,  unique = true)
    private String username;
    
    /* Password (paswordhash) */
    @Column(name = "password", nullable = false)
    private String password;
    
    /* Email (unique) */
    @Column(name = "email", nullable = false, updatable = true,  unique = true)
    private String email;
    
    @Column(name = "role", nullable = false)
    private String role;

    public AppUser() {}

    /* Constructors */
    public AppUser(String username, String password, String email, String role) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /* Getters */
    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    /* Setters */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

