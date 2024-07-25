package com.training.justdab.repository;

import com.training.justdab.model.AppUser;
import com.training.justdab.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    AppUser findByUsername(String username);

    AppUser save(AppUser appUser);

    Client findById(int id);

    List<Client> findAll();

    List<Client> findAllByAdvisorId(int advisorId);
}
