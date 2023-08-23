package com.ltimindtree.notificationservice.controller;

import com.ltimindtree.notificationservice.model.Notifications;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {


    @GetMapping("/{notificationId}")
    public Notifications getNotifications(@PathVariable  Long notificationId){
        Notifications notifications = new Notifications(notificationId,"Notifications"+notificationId);
        return notifications;
    }
}
