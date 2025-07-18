package org.example.onetooneuni.service;

import org.example.onetooneuni.model.PlayerProfile;
import org.example.onetooneuni.repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerProfileRepository profileRepo;

    public List<PlayerProfile> getAll(){
        return profileRepo.findAll();
    }

    public PlayerProfile getProfile(int id){
        return profileRepo.findById(id).get();
    }

    public PlayerProfile addProfile(PlayerProfile profile){
        profile.setId(0);
        return profileRepo.save(profile);
    }

    public void deleteProfile(int id){
        profileRepo.deleteById(id);
    }
}
