package com.testproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testproject.model.User;
import com.testproject.model.UserRequest;
import com.testproject.services.UserService;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;
import java.util.Date;
import java.util.UUID;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    UserRequest userRequest;

    @Autowired
    ObjectMapper objectMapper;
    @BeforeEach
    void onUp(){
        userRequest = new UserRequest("Viraj","Kumbhar");
    }

    @Test
    public void success_registerUser() throws  Exception{
        User user = new User(UUID.randomUUID(),"Viraj Kumbhar",0, new Date());

        Mockito.when(userService.save(ArgumentMatchers.any(UserRequest.class))).thenReturn(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(user.getFullName()));

    }


}
