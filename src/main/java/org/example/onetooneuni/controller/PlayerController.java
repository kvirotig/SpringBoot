package org.example.onetooneuni.controller;

import org.example.onetooneuni.model.Player;
import org.example.onetooneuni.model.PlayerProfile;
import org.example.onetooneuni.service.PlayerProfileService;
import org.example.onetooneuni.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    PlayerService playerService;
    @Autowired
    PlayerProfileService playerProfileService;

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> playerList = playerService.getAllPlayers();
        return ResponseEntity.ok(playerList);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayer(final @PathVariable Integer playerId){
        Player player = playerService.getPlayer(playerId);
        return ResponseEntity.ok(player);
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player player1 = playerService.addPlayer(player);
        return ResponseEntity.ok(player1);
    }

    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable int playerId){
        playerService.delete(playerId);
    }

    @PutMapping("/assignProfile/{playerId}/{profileId}")
    public Player assignProfile(@PathVariable int playerId,@PathVariable int profileId){
        PlayerProfile profile = playerProfileService.getProfile(profileId);
        return playerService.assignProfile(playerId,profile);
    }

}
