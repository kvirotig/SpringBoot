package org.example.onetooneuni.service;

import org.example.onetooneuni.model.Player;
import org.example.onetooneuni.model.PlayerProfile;
import org.example.onetooneuni.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepo;

    public List<Player> getAllPlayers(){
       return playerRepo.findAll();
    }

    public Player getPlayer(int id){
        return playerRepo.findById(id).get();
    }

    public Player addPlayer(Player player){
        player.setId(0);
       return playerRepo.save(player);
    }

    public void delete(int id){
        playerRepo.deleteById(id);
    }

    public Player assignProfile(int id, PlayerProfile profile) {
        Player player = playerRepo.findById(id).get();
        player.setPlayerProfile(profile);
        return playerRepo.save(player);
    }

}
