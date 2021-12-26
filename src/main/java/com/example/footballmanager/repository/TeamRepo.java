package com.example.footballmanager.repository;

import com.example.footballmanager.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepo extends CrudRepository <TeamEntity, Long> {
    TeamEntity findByname(String name);
}
