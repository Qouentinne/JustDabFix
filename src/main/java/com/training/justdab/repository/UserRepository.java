package com.training.justdab.repository;

import com.training.justdab.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByUsername(String username);

    AppUser save(AppUser appUser);

}
