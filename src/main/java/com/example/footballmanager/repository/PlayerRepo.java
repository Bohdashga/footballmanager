package com.example.footballmanager.repository;


import com.example.footballmanager.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<PlayerEntity, Long > {

}
