package com.example.footballmanager.service;

import com.example.footballmanager.entity.PlayerEntity;
import com.example.footballmanager.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public PlayerEntity createPlayer(PlayerEntity player) {

       return playerRepo.save(player);
    }

    //not ready
    public PlayerEntity updatePlayer (PlayerEntity player, Long id) throws Exception {
        PlayerEntity existPlayer = playerRepo.findById(id).get();

        if(existPlayer == null){
            throw new Exception("Player not found");
        }
        return player;
    }

    public void deletePlayer(Long id) throws Exception {
        PlayerEntity existPlayer = playerRepo.findById(id).get();
        if(existPlayer == null){
            throw new Exception("Player not found");
        }
       playerRepo.delete(existPlayer);
        return;
    }

    public PlayerEntity getByID(Long id) {
         return playerRepo.findById(id).get();
    }

    public List<PlayerEntity> getAll() {
        return (List<PlayerEntity>) playerRepo.findAll();
    }

}

