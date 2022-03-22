package it.extendi.mail.dao;

import javax.persistence.*;

@Entity
public class UserDAO {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    private RoleDAO role;
    private String apiKey;

    public UserDAO() {}
    public UserDAO(String email, String password, RoleDAO role, String apiKey) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.apiKey = apiKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDAO getRole() {
        return role;
    }

    public void setRole(RoleDAO role) {
        this.role = role;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
