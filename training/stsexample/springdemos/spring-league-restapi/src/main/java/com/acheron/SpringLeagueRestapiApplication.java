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
import com.acheron.model.Matches;
import com.acheron.model.Sports;
import com.acheron.model.SportView;
import com.acheron.model.Team;
import com.acheron.service.IBoardService;
import com.acheron.service.ILeagueService;
import com.acheron.service.ISportsService;

@SpringBootApplication
public class SpringLeagueRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringLeagueRestapiApplication.class, args);
	}

	@Autowired
	ILeagueService leagueService;
	@Autowired
	IBoardService ownerService;

	@Autowired
	ISportsService sportsService;

	@Override
	public void run(String... args) throws Exception {
////		Owner owner = new Owner("mumbai", "Business");
////		ownerService.addowner(owner);
////
////		Owner owner1 = new Owner("banglore", "CarBusiness");
////		ownerService.addowner(owner1);
////
//		Board board2 = new Board("hydrabad", "BikeBusiness");
//		ownerService.addowner(board2);
//
//		Board board3 = new Board("hydrabad", "HotelBusiness");
//		ownerService.addowner(board3);
////
//		Board oneleague = ownerService.getById(1);
//		Board twoleague = ownerService.getById(2);
////
////		League league = new League("RCB", "banglore", 2, oneleague);
////		League league2 = new League("SHB", "hyderabed", 2, twoleague);
////
////		leagueService.addleague(league);
////		leagueService.addleague(league2);
//
//		// leagueService.deleteleague(2);
//
//		Team team1 = new Team("RCB", "Prasanna");
//		Team team2 = new Team("RR", "Teja");
//
//		Set<Team> teamList = new HashSet<>(Arrays.asList(team1, team2));
//
//		Matches match1 = new Matches("RR VS RCB", "banglore", teamList);
//		Matches match2 = new Matches("RR VS MI", "hyderabad", teamList);
//		Matches match3 = new Matches("RCB VS MI", "mumbai", teamList);
//
//		Set<Matches> matches = new HashSet<>(Arrays.asList(match1, match2, match3));
//
//		Sports sports = new Sports("india", "cricket");
//		sportsService.addSports(sports);
//		League league = new League("CSK", "Chennai", 5, oneleague, matches, sports);
//		// leagueService.addleague(league);
//		League league1 = new League("RCB", "Banglore", 8, twoleague, matches, sports);
//		// leagueService.addleague(league1);

//		List<LeagueView> leagueview = leagueService.getLeagueDeatails();
//		for (LeagueView leagueDetails : leagueview) {
//			System.out.println(
//					leagueDetails.getNAME() + "\t" + leagueDetails.getDURATION() + "\t" + leagueDetails.getCOUNTRY());
//		}

//		List<SportView> sportsview = sportsService.getSportsDetails();
//		for (SportView sportsDetails : sportsview) {
//			System.out.println(sportsDetails.getLEAGUENAME() + "\t" + sportsDetails.getLEAGUENAME() + "\t"
//					+ sportsDetails.getMEMBERCITY() + "\t" + sportsDetails.getSPORTSNAME() + "\t"
//					+ sportsDetails.getSTADIUM());
//		}
		
		
	//	System.out.println(leagueService.getLeagueCount("chennai"));
		leagueService.getLeagueByBoard("hydrabad").forEach(System.out::println);
	}

}
