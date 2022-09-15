package com.acheron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acheron.model.Board;

@Repository
public interface IBoardRepository extends JpaRepository<Board, Integer> {

}
