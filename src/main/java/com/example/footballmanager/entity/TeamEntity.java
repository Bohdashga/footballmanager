package com.example.footballmanager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String city;
    private String country;
    private float balance;
    private float commission;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<PlayerEntity> players;

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayer(PlayerEntity player){
        players.add(player);
    }

    public TeamEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
