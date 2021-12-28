package com.example.footballmanager.controller;

import com.example.footballmanager.entity.PlayerEntity;
import com.example.footballmanager.repository.PlayerRepo;
import com.example.footballmanager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/")
    public ResponseEntity createPlayer (@RequestBody PlayerEntity player) {
        try {
            return ResponseEntity.ok(playerService.createPlayer(player));

        } catch (Exception e){
            return  ResponseEntity.badRequest().body("Fail");
        }
    }



    @PutMapping
    public ResponseEntity updatePlayer (@RequestBody PlayerEntity player, @RequestParam Long  id) {
        try {
            return ResponseEntity.ok(playerService.updatePlayer(player,id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity getPlayerById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(playerService.getByID(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deletePlayerById(@RequestParam Long id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.ok("delete successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @GetMapping("/")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(playerService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @PatchMapping("/{playerId}/team/{teamId}")
    public ResponseEntity addPlayerToTeam(@PathVariable("teamId") Long teamId, @PathVariable("playerId") Long playerId){
        try {
            return ResponseEntity.ok(playerService.addPlayerToTeam(playerId, teamId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/from-team")
    public ResponseEntity removePlayerFromTeam(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(playerService.removePlayerFromTeam(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/set-sell")
    public ResponseEntity sellingPlayer(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(playerService.sellPlayer(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
