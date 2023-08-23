package com.userservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonSerialize
public class User implements Serializable {

    //@Id
    private Long id;
    private String name;
    private String phoneNo;
    //private Profile profile;
    private Posts posts;
    private Notifications notifications;

    public User(Long id, String name, String phoneNo){
        this.id = id;
        this.name=name;
        this.phoneNo=phoneNo;
    }

}
