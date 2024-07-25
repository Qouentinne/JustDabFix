package com.training.justdab.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(RoleType.CLIENT)
public class Client extends AppUser {

    @ManyToOne
    @JoinColumn(name = "advisor_id",  referencedColumnName = "id")
    private Employee advisor;

    public Client(String username, String password, String role) {
        super(username, password, role);
    }

    protected Client() {}

    public Employee getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Employee advisor) {
        this.advisor = advisor;
    }
}
