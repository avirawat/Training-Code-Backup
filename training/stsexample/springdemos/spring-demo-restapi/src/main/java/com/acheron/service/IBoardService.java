package com.acheron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acheron.model.Board;

@Service
public interface IBoardService {

	Board addboard(Board board);

	void updateboard(Board board);

	void deleteboard(int boardId);

	Board getById(int boardId);

	List<Board> getAllboard();
}
