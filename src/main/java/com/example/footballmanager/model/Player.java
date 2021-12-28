package com.example.footballmanager.model;

import com.example.footballmanager.entity.PlayerEntity;
import com.example.footballmanager.entity.TeamEntity;

import java.util.Date;

public class Player {
    private Long id;
    private String firstName;
    private String surName;
    private int age;
    private int experience;
    private float price;
    private Date startCareer;
    private Team team;

    public static Player toModel(PlayerEntity player){
        Player model = new Player();
        model.setId(player.getId());
        model.setFirstName(player.getFirstname());
        model.setSurName(player.getSurname());
        model.setExperience(player.getExperience());
        model.setAge(player.getAge());
        model.setStartCareer(player.getStartСareer());
        model.setPrice(player.getPrice());

        return model;
    }

    public Player(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getStartCareer() {
        return startCareer;
    }

    public void setStartCareer(Date startCareer) {
        this.startCareer = startCareer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
