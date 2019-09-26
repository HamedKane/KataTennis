package com.kata.tennis3;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private String currentService;
	private int currentGameStatus;
	private int nbrGame;
	private List<Integer>listScoreGame = new ArrayList<>();
	private int nbrSet;
	private boolean isMatchWinner;
	private String matchStatus;
	
	
	public Player(String name, String currentService, int currentGameStatus, 
			int nbrGame, List<Integer> listScoreGame, int nbrSet, boolean  isMatchWinner, String matchStatus) {
		this.name = name;
		this.currentService = currentService;
		this.currentGameStatus = currentGameStatus;
		this.nbrGame = nbrGame;
		this.listScoreGame = listScoreGame;
		this.nbrSet = nbrSet;
		this.isMatchWinner = isMatchWinner;
		this.matchStatus = matchStatus;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCurrentService() {
		return currentService;
	}
	public void setCurrentService(String currentAction) {
		this.currentService = currentAction;
	}
	public int getCurrentGameStatus() {
		return currentGameStatus;
	}
	public void setCurrentGameStatus(int currentgameStatus) {
		this.currentGameStatus = currentgameStatus;
	}
	public int getNbrGame() {
		return nbrGame;
	}
	public void setNbrGame(int nbrGame) {
		this.nbrGame = nbrGame;
	}
	public int getNbrSet() {
		return nbrSet;
	}
	public void setNbrSet(int nbrSet) {
		this.nbrSet = nbrSet;
	}
	public boolean isMatchWinner() {
		return isMatchWinner;
	}
	public void setMatchWinner(boolean isMatchWinner) {
		this.isMatchWinner = isMatchWinner;
	}
	public List<Integer> getListScoreGame() {
		return listScoreGame;
	}
	public void setListScoreGame(List<Integer> listScoreGame) {
		this.listScoreGame = listScoreGame;
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}
	
}
