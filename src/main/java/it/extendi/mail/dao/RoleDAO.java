package it.extendi.mail.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RoleDAO {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(
            targetEntity = UserDAO.class,
            mappedBy = "role",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserDAO> userSet;

    public RoleDAO(){}
    public RoleDAO(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
