package com.training.justdab.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAccountTest() throws Exception {
        mockMvc.perform(get("/clients/1/account"))
                .andExpect(status().isOk());
    }

    @Test
    void updateBalanceWithPositiveAmountTest() throws Exception {
        int amount = 10;
        mockMvc.perform(put("/clients/1/account/balance")
                        .queryParam("amountToAddOrWithdraw", String.valueOf(amount)))
                .andExpect(status().isOk());
    }

    @Test
    void updateBalanceWithNegativeAmountTest() throws Exception {
        int amount = -10;
        mockMvc.perform(put("/clients/1/account/balance")
                        .queryParam("amountToAddOrWithdraw", String.valueOf(amount)))
                .andExpect(status().isOk());
    }

    @Test
    void getAdvisorTest() throws Exception {
        mockMvc.perform(get("/clients/1/advisor"))
                .andExpect(status().isOk());
    }

}
