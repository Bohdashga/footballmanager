package com.example.footballmanager.controller;

import com.example.footballmanager.entity.PlayerEntity;
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

    @PatchMapping
    public ResponseEntity updatePlayer (@RequestBody PlayerEntity player, @RequestParam Long  id) {
        try {
            return ResponseEntity.ok(player);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @GetMapping
    public  ResponseEntity getPlayerById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(playerService.getByID(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @DeleteMapping
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



}
