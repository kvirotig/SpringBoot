package org.example.onetooneuni.repository;

import org.example.onetooneuni.model.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerProfileRepository extends JpaRepository<PlayerProfile,Integer> {
}
