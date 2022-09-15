package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.model.Board;
import com.acheron.repository.IBoardRepository;

@Service
public class BoardServiceImpl implements IBoardService {

	@Autowired 
	IBoardRepository boardRepository;
	
	@Override
	public Board addboard(Board board) {
		return boardRepository.save(board);
	}

	@Override
	public void updateboard(Board board) {
		boardRepository.save(board);
		
	}

	@Override
	public void deleteboard(int boardId) {
		boardRepository.deleteById(boardId);
	}

	@Override
	public Board getById(int boardId) {
		return boardRepository.findById(boardId).get();
	}

	@Override
	public List<Board> getAllboard() {
		return boardRepository.findAll();
	}


	
}
