package com.acheron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acheron.model.Matches;

@Repository
public interface IMatchRepository extends JpaRepository<Matches, Integer> {

}
