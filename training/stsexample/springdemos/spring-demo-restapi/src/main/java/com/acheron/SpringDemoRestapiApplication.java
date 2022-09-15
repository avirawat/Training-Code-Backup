package com.acheron;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acheron.model.Board;
import com.acheron.model.League;
import com.acheron.model.LeagueView;
import com.acheron.model.Player;
import com.acheron.model.Fixtures;
import com.acheron.model.Sports;
import com.acheron.model.SportView;
import com.acheron.model.Team;
import com.acheron.service.IBoardService;
import com.acheron.service.ILeagueService;
import com.acheron.service.ISportService;

@SpringBootApplication
public class SpringDemoRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoRestapiApplication.class, args);
	}

	@Autowired
	ILeagueService leagueService;

	@Autowired
	IBoardService boardService;

	@Autowired
	ISportService sportsService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(leagueService.getById(1));
//		Board board = new Board("BCCI", "Mumbai", "/assets/images/board/cmember.jpg");
//		boardService.addboard(board);
//
//		Sports csports = new Sports("Cricket", "England", "/assets/images/sports/cricket.jpg");
//		sportsService.addSport(csports);
//		Sports tsports = new Sports("Tennis", "England", "/assets/images/sports/tennis.jpg");
//		sportsService.addSport(tsports);
//		Sports fsports = new Sports("Football", "England", "/assets/images/sports/football.jpg");
//		sportsService.addSport(fsports);
//		
//		//Team-1
//		Player player1 = new Player("Rahul", 22, "Blg", "/assets/images/sports/rahul.jpg");
//		Player player2 = new Player("Manav", 24, "Blg", "/assets/images/sports/manav.jpg");
//		Set<Player> playerSetOne = new HashSet<>(Arrays.asList(player1, player2));
//		
//		Team teamOne = new Team("TeamOne", "Joel",playerSetOne,"/assets/images/teams/teamone.jpg");
//		
//		//Team-2
//		Player player3 = new Player("David", 22, "Mumbai", "/assets/images/players/david.jpg");
//		Player player4 = new Player("Avinash", 24, "Mumbai", "/assets/images/players/avinash.jpg");
//		Set<Player> playerSetTwo = new HashSet<>(Arrays.asList(player3, player4));
//		
//		Team teamTwo = new Team("TeamTwo", "Kumaran",playerSetTwo,"/assets/images/teams/teamtwo.jpg");
//		
//		//Team-3
//		Player player5 = new Player("Manish", 21, "Chennai", "/assets/images/players/mani.jpg");
//		Player player6 = new Player("Raju", 24, "Chennai", "/assets/images/players/raju.jpg");
//		Set<Player> playerSetThree = new HashSet<>(Arrays.asList(player5, player6));
//		
//		Team teamThree = new Team("TeamThree", "Srini",playerSetThree,"/assets/images/teams/teamthree.jpg");
//		
//		Set<Team> teams = new HashSet<>(Arrays.asList(teamOne,teamTwo));
//		
//		Fixtures match1=new Fixtures("CSK vs MI","Chinnapa Stadium","/assets/images/fixtures/match1.jpg");
//		match1.setTeams(teams);
//		
//		Set<Team> nteams = new HashSet<>(Arrays.asList(teamOne,teamThree));
//		
//		Fixtures match2=new Fixtures("RCB vs CSK","Chinnapa Stadium","/assets/images/fixtures/match2.jpg");
//		match2.setTeams(nteams);
//		
//		Set<Fixtures> fixtures=new HashSet<>(Arrays.asList(match1,match2));
//		League league=new League();
//		league.setDurationInMonths(1);
//		league.setName("T20");
//		league.setBoard(board);
//		league.setFixtures(fixtures);
//		league.setSports(fsports);
//		leagueService.addLeague(league);

//	Fixtures match1=new Fixtures("HK vs BR","delhi stadium",allTeam);
//	Fixtures match2=new Fixtures("TD VS HK"," sthydd",allTeam);
//	Set<Fixtures> allMatch=new HashSet<>(Arrays.asList(match1,match2));
//	
//	Sports sport=new Sports("Cricket","England");
//	
//	League league=new League("T20","INdia",1,owner,allMatch,sport);

//		sportService.addSport(sport);
//		leagueService.addLeague(league);

		// leagueService.deleteLeague(3);
		// Owner owner=ownerService.getById(100);
//	League league=new League("IPL","INdia",14,owner);
//	leagueService.addLeague(league);

//	List<LeagueView> leagueView=leagueService.getLeagueDetails();
//	for(LeagueView leagueDetails:leagueView) {
//		System.out.println(leagueDetails.getNAME()+"\t"+leagueDetails.getDURATION()+"\t"+leagueDetails.getCOUNTRY());
//	}
//	
//	List<SportView> sportView=sportService.getAllSports();
//			
//	for(SportView sportDetails:sportView) {
//		System.out.println(sportDetails.getSPORTNAME()+"\t"+sportDetails.getDURATION()+"\t"+sportDetails.getSQUAD()+"\t"+sportDetails.getSTADIUM());
//	}

//	System.out.println(leagueService.getLeagueCount("India"));
//	leagueService.getLeagueByBoard("BCCI").forEach(System.out::println);
	}

}
