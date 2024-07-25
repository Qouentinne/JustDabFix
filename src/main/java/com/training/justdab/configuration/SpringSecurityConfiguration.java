package com.training.justdab.configuration;

import com.training.justdab.model.RoleType;
import com.training.justdab.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.core.userdetails.User.builder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/advisor/welcome").hasRole(RoleType.ADVISOR)
                        .requestMatchers("/client/welcome").hasRole(RoleType.CLIENT)
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/welcome", true)
                )
                .build();
    }

//    @Bean
//    public UserDetailsService users() {
//        UserDetails client = builder()
//                .username("client")
//                .password(passwordEncoder().encode("password"))
//                .roles(RoleType.CLIENT)
//                .build();
//        UserDetails advisor = builder()
//                .username("advisor")
//                .password(passwordEncoder().encode("password"))
//                .roles(RoleType.ADVISOR)
//                .build();
//        return new InMemoryUserDetailsManager(client, advisor);
//    }

    @Bean
    public AuthenticationManager authenticationManager(BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
