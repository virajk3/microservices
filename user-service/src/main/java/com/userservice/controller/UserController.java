package com.userservice.controller;

import com.userservice.model.Notifications;
import com.userservice.model.Posts;
import com.userservice.model.Profile;
import com.userservice.model.User;
import com.userservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    public static final String USER_SERVICE = "user-service";


    @GetMapping("/{id}")
    @CircuitBreaker(name=USER_SERVICE,fallbackMethod = "userServiceFallBack")
    public User getUser(@PathVariable  Long id){
        User user = new User(id,"Viraj","XXXXX",null,null);
        //Profile profile = restTemplate.getForObject("http://localhost:9002/profile/1", Profile.class);
        //user.setProfile(profile);

        Posts posts = restTemplate.getForObject(
                "http://post-service/post/"+id, Posts.class);

        Notifications notifications = restTemplate.getForObject(
                "http://notification-service/notifications/"+id, Notifications.class);

        user.setPosts(posts);
        user.setNotifications(notifications);

        return user;
    }


    public User userServiceFallBack(Exception userException){
        return new User(1L,"user_1","XYZ");
    }

}
