package com.restfulapi.demo.controller;

import com.restfulapi.demo.entity.User;
import com.restfulapi.demo.entity.result.ResponseData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    @Test
    void getUserList() throws Exception
    {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/user/")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$..name").value("default"))
                /*getUserList()±ªJsonView–ﬁ Œ£¨÷ªœ‘ æname*/
                .andExpect(MockMvcResultMatchers.jsonPath("$..password").doesNotExist());
    }

    @BeforeEach
    void setUp()
    {
        System.out.println("Before each......");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("After each......");
    }

    @Test
    void testAddUser()
    {
    }
}