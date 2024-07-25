package com.training.justdab.configuration;

import com.training.justdab.model.Client;
import com.training.justdab.model.Employee;
import com.training.justdab.model.RoleType;
import com.training.justdab.model.AppUser;
import com.training.justdab.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadyLoaded = false;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(!alreadyLoaded) {
            loadUsers();
            alreadyLoaded = true;
        }
    }

    private void loadUsers() {
        AppUser client = new Client("client", passwordEncoder.encode("password"), RoleType.CLIENT);
        AppUser advisor = new Employee("advisor", passwordEncoder.encode("password"), RoleType.ADVISOR);
        userRepository.save(client);
        userRepository.save(advisor);
    }
}
