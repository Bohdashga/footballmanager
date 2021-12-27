package com.example.footballmanager.service;

import com.example.footballmanager.entity.TeamEntity;
import com.example.footballmanager.exception.TeamAlreadyExistException;
import com.example.footballmanager.exception.TeamNotFoundException;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    public List<TeamEntity> getAllTeam() {
        return (List<TeamEntity>) teamRepo.findAll();
    }

    public TeamEntity registration(TeamEntity team) throws TeamAlreadyExistException {
        if(teamRepo.findByName(team.getName()) != null) {
            throw new TeamAlreadyExistException("Команда з такою назвою уже існує");
        }
        return teamRepo.save(team);
    }

    public TeamEntity updateTeam(TeamEntity team, Long id) throws Exception {
        TeamEntity existTeam = teamRepo.findById(id).get();
        if(existTeam == null) {
            throw new Exception("Team not found");
        }
        existTeam.setName(team.getName());
        existTeam.setCity(team.getCity());
        existTeam.setCountry(team.getCountry());
        existTeam.setBalance(team.getBalance());
        existTeam.setCommission(team.getCommission());

        return teamRepo.save(existTeam);

    }

    public Team getOne(Long id) throws TeamNotFoundException {
        TeamEntity team = teamRepo.findById(id).get();
        if( team == null) {
            throw new TeamNotFoundException("Команда не знайдена");
        }
        return Team.toModel(team);
    }


    public Long delete(Long id) {
        teamRepo.deleteById(id);
        return id;
    }

}
