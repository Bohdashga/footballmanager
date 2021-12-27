package com.example.footballmanager.controller;

import com.example.footballmanager.entity.TeamEntity;
import com.example.footballmanager.exception.TeamAlreadyExistException;
import com.example.footballmanager.exception.TeamNotFoundException;
import com.example.footballmanager.repository.TeamRepo;
import com.example.footballmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity registration(@RequestBody TeamEntity team) {
        try {
            teamService.registration(team);
            return ResponseEntity.ok("Команда успішно збережена");
        } catch (TeamAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Виникла помилка");
        }
    }

    @PutMapping
    public ResponseEntity updateTeam(@RequestBody TeamEntity team,@RequestParam Long id) {
        try {
            return ResponseEntity.ok(teamService.updateTeam(team,id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed update");
        }
    }

    @GetMapping
    public ResponseEntity getOneTeam(@RequestParam Long id) { // function check if server work
        try {
            return ResponseEntity.ok(teamService.getOne(id));
        } catch (TeamNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Виникла помилка");
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeam(@PathVariable Long id){
        try {
            return ResponseEntity.ok(teamService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Виникла помилка");
        }
    }

    @GetMapping
    public ResponseEntity getAllTeam() {
        try {
            return ResponseEntity.ok(teamService.getAllTeam());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

}
