package com.example.footballmanager.model;

import com.example.footballmanager.entity.PlayerEntity;
import com.example.footballmanager.entity.TeamEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Team {
    private Long id;
    private String name;
    private String country;
    private String city;
    private List<Player> players;

    public static Team toModel(TeamEntity entity) {
        Team model = new Team();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setCity(entity.getCity());
        model.setCountry(entity.getCountry());
        model.setPlayers(entity.getPlayers().stream().map(Player::toModel).collect(Collectors.toList()));
        return model;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Team() {
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
