package com.example.footballmanager.entity;


import com.sun.istack.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String firstname;
    private String surname;
    private int age;
    private int experience;
    private float price;
    private Boolean isSell;
    private Date startСareer;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

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

    public Boolean getSell() {
        return isSell;
    }

    public void setSell(Boolean sell) {
        isSell = sell;
    }



    public PlayerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    public Date getStartСareer() {
        return startСareer;
    }

    public void setStartСareer(Date startСareer) {
        this.startСareer = startСareer;
    }
}
