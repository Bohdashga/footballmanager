package com.example.footballmanager.model;

import com.example.footballmanager.entity.TeamEntity;

public class Team {
    private Long id;
    private String name;

    public static  Team toModel(TeamEntity entity) {
        Team model = new Team();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
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
}
