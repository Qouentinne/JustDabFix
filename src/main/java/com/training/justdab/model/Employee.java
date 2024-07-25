package com.training.justdab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(RoleType.ADVISOR)
public class Employee extends AppUser {

    @JsonBackReference
    @OneToMany(mappedBy = "advisor")
    private List<Client> clients;

    public Employee(String username, String password, String role) {
        super(username, password, role);
    }

    protected Employee() {}

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
