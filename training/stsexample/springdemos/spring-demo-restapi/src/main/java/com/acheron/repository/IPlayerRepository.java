package com.acheron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acheron.model.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player,Integer> {

}
