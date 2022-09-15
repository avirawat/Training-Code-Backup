package com.acheron.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.acheron.model.League;
import com.acheron.model.LeagueView;

@Repository
public interface ILeagueRepository extends JpaRepository<League,Integer> {
	
	@Query(value="select * from leagueview",nativeQuery=true)
	List<LeagueView> getLeagueDetails();
	
	//using named Query
	@Query(name="findByBoard")
	List<League>findLeagueByBoard(String boardName);
	
	@Procedure
	Integer GET_LEAGUE_COUNT(String country);
	
//	@Procedure(procedureName = "GET_LEAGUE_COUNT")
//	Integer getTotalLeagues(String country);
}
