package com.sixplus.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
//@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String nickname;

//    public String getUsername(){return username;}
//
//    public String getPassword(){return password;}
}
