/**
 * 
 */
package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.model.Board;
import com.acheron.repository.IBoardRepository;

/**
 * @author SumanD
 *
 */
@Service
public class IBoardServiceImp implements IBoardService {
	@Autowired
	IBoardRepository ownerRepository;

	@Override
	public Board addowner(Board owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void updateowner(Board owner) {
		ownerRepository.save(owner);
	}

	@Override
	public void deleteowner(int ownerId) {
		ownerRepository.deleteById(ownerId);
	}

	@Override
	public Board getById(int ownerId) {
		return ownerRepository.getById(ownerId);
	}

	@Override
	public List<Board> getall() {
		return ownerRepository.findAll();
	}

}
