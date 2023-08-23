package com.userservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile implements Serializable {

    private Long id;
    private List<String> posts;
    private List<String> notifications;


}
