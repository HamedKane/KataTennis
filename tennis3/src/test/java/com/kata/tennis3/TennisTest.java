package com.kata.tennis3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kata.tennis3.CurrentService;
import com.kata.tennis3.IParameters;
import com.kata.tennis3.Player;
import com.kata.tennis3.Tennis;

import junit.framework.TestCase;


public class TennisTest extends TestCase {
	
	@Test
	public void testManageCurrentGameStatus0To15() {	
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_0
				, 0, null, 0, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_DEUCE
				, 0, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();		
		tennis.ManageCurrentGameStatus(p1 , p2);
		assertEquals(IParameters.GAME_STATUS_15,p1.getCurrentGameStatus());
	}
	
	@Test
	public void testManageCurrentGameStatus15To30() {		
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_15
				, 0, null, 0, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_DEUCE
				, 0, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();		
		tennis.ManageCurrentGameStatus(p1 , p2);
		assertEquals(IParameters.GAME_STATUS_30,p1.getCurrentGameStatus());
	}
	
	@Test
	public void testManageCurrentGameStatus30To40() {	
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_30
				, 0, null, 0, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_DEUCE
				, 0, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();
		tennis.ManageCurrentGameStatus(p1 , p2);
		assertEquals(IParameters.GAME_STATUS_40,p1.getCurrentGameStatus());
	}
	
	@Test
	public void testManageCurrentGameStatusDeuce() {	
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_30
				, 0, null, 0, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_40
				, 0, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();		
		tennis.ManageCurrentGameStatus(p1 , p2);
		assertEquals(IParameters.GAME_STATUS_DEUCE,p1.getCurrentGameStatus());
	}
	
	@Test
	public void testManageCurrentGameStatusDeuceToAdvantage() {	
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_DEUCE
				, 0, null, 0, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_DEUCE
				, 0, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();
		tennis.ManageCurrentGameStatus(p1 , p2);
		assertEquals(IParameters.GAME_STATUS_ADVANTAGE,p1.getCurrentGameStatus());
	}
	
	@Test
	public void testManageCurrentGameStatusAdvantageToDeuce() {	
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_DEUCE
				, 0, null, 0, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_ADVANTAGE
				, 0, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();		
		tennis.ManageCurrentGameStatus(p1 , p2);
		assertEquals(IParameters.GAME_STATUS_DEUCE,p2.getCurrentGameStatus());
	}
	
	@Test
	public void testManageGames() {
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_40
				, 3, null, 0, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_15
				, 1, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();
		tennis.manageGame(p1, p2);
		assertEquals(4,p1.getNbrGame());
	}
	
	@Test
	public void testManageSets() {
		
		List<Integer>listScoreGame1 = new ArrayList();
		List<Integer>listScoreGame2 = new ArrayList();
		
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_40
				, 6, listScoreGame1, 1, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_15
				, 1, listScoreGame2, 0, false, "In progress");
		
		Tennis tennis = new Tennis();
		tennis.manageSet(p1, p2);
		assertEquals(2,p1.getNbrSet());
	}
	
	@Test
	public void testManageMatchs() {
		
		Player p1 = new Player("Playeur1", CurrentService.W.toString(), IParameters.GAME_STATUS_40
				, 0, null, 3, false, "In progress");
		
		Player p2 = new Player("Playeur2", CurrentService.L.toString(), IParameters.GAME_STATUS_15
				, 0, null, 0, false, "In progress");
		
		Tennis tennis = new Tennis();
		tennis.manageMatch(p1, p2);
		assertEquals(true,p1.isMatchWinner());
		assertEquals(false,p2.isMatchWinner());
	}

}
