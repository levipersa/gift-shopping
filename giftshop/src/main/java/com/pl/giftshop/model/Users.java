package com.pl.giftshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;





}
