package com.profileservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.profileservice.model.Profile;
import com.profileservice.services.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProfileService profileService;


    Profile profile;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach void onUp(){
        ArrayList<String> posts = new ArrayList<>();
        posts.add("Post 1");
        posts.add("Post 2");
        ArrayList<String> notifications = new ArrayList<>();
        notifications.add("Notification 1");
        notifications.add("Notification 2");
        profile = new Profile(1L,posts,notifications);

        MockitoAnnotations.openMocks(this);
    }


    @Test void getUserProfiles() throws Exception{
        Mockito.when(profileService.getUserProfile(ArgumentMatchers.anyLong())).thenReturn(profile);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/profile/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profile))
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(profile.getId()));
    }

}
