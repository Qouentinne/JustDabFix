package com.training.justdab.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdvisorControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllClientsOfSpecifiedAdvisor() throws Exception {
        mockMvc.perform(get("/advisor/3/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllClients() throws Exception {
        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }
}
