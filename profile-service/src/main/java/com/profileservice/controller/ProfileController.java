package com.profileservice.controller;

import com.profileservice.model.Profile;
import com.profileservice.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @GetMapping("/{id}")
    public Profile getUserProfile(@PathVariable  Long id){
        ArrayList<String> posts = new ArrayList<>();
        posts.add("Post 1");
        posts.add("Post 2");
        ArrayList<String> notifications = new ArrayList<>();
        notifications.add("Notification 1");
        notifications.add("Notification 2");
        Profile profile = new Profile(1L,posts,notifications);

        return profile;
    }

}
