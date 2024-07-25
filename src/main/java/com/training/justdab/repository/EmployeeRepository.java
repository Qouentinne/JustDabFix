package com.training.justdab.repository;

import com.training.justdab.model.AppUser;
import com.training.justdab.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    AppUser findByUsername(String username);
    AppUser save(AppUser appUser);
}
