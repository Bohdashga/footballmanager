package com.example.footballmanager.service;

import com.example.footballmanager.entity.PlayerEntity;
import com.example.footballmanager.entity.TeamEntity;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.PlayerRepo;
import com.example.footballmanager.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private TeamRepo teamRepo;

    public PlayerEntity createPlayer(PlayerEntity player) {
       return playerRepo.save(player);
    }


    public Player updatePlayer (PlayerEntity player, Long id) throws Exception {

        PlayerEntity existPlayer = playerRepo.findById(id).get();
        if(existPlayer == null){
            throw new Exception("Player not found");
        }
        existPlayer.setFirstname(player.getFirstname());
        existPlayer.setSurname(player.getSurname());
        existPlayer.setAge(player.getAge());
        existPlayer.setExperience(player.getExperience());
        existPlayer.setPrice(player.getPrice());
        existPlayer.setTeam(player.getTeam());


        return Player.toModel(playerRepo.save(existPlayer));
    }

    public void deletePlayer(Long id) throws Exception {
        PlayerEntity existPlayer = playerRepo.findById(id).get();
        if(existPlayer == null){
            throw new Exception("Player not found");
        }
        playerRepo.delete(existPlayer);
        return;
    }

    public Player getByID(Long id) {
         return Player.toModel(playerRepo.findById(id).get());
    }

    public List<PlayerEntity> getAll() {
        return (List<PlayerEntity>) playerRepo.findAll();
    }

    public Player addPlayerToTeam(Long playerId, Long teamId) throws Exception {
        PlayerEntity player = playerRepo.findById(playerId).get();
        if (player == null){
            throw new Exception("Player not found");
        }

        TeamEntity team = teamRepo.findById(teamId).get();

        if(team == null){
            throw new Exception("Team not found");
        }

        if(!player.getSell()){
            throw new Exception("Player is not sell");
        }

        TeamEntity playerCurrentTeam = player.getTeam();
        float priceForBuyPlayer = player.getExperience() * 100000 / player.getAge();
        float commission = priceForBuyPlayer * playerCurrentTeam.getCommission() / 100;
        float fullPrice = priceForBuyPlayer + commission;

        if(team.getBalance() <= fullPrice){
            throw new Exception("Team balance is less");
        }

        team.setBalance(team.getBalance() - fullPrice);
        playerCurrentTeam.setBalance(playerCurrentTeam.getBalance() + fullPrice);

        player.setTeam(team);
        player.setSell(false);
        playerRepo.save(player);
        teamRepo.save(team);
        teamRepo.save(playerCurrentTeam);

        return Player.toModel(player);
    }

    public Player removePlayerFromTeam(Long id) throws Exception {
        PlayerEntity player = playerRepo.findById(id).get();

        if(player == null){
            throw new Exception("Player not found");
        }

        player.setTeam(null);
        player.setSell(true);
        playerRepo.save(player);

        return Player.toModel(player);
    }

    // Use when player in team but he is selling
    public Player sellPlayer(Long id) throws Exception{
        PlayerEntity player = playerRepo.findById(id).get();

        if (player == null){
            throw new Exception("Player not found");
        }

        player.setSell(true);
        playerRepo.save(player);
        return Player.toModel(player);
    }

}

