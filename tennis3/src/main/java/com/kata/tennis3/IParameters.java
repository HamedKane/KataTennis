package com.kata.tennis3;

import java.util.List;

public interface IParameters {
	
	public static final int GAME_STATUS_0 = 0;
	public static final int GAME_STATUS_15 = 1;
	public static final int GAME_STATUS_30 = 2;
	public static final int GAME_STATUS_40 = 3;
	public static final int GAME_STATUS_DEUCE = 4;
	public static final int GAME_STATUS_ADVANTAGE = 5;
	
	public static String convertStatusGameToString(int status) {		
		String statusGameString = null;
		switch(status) {
		  case 0:
			  statusGameString = "0";
		    break;
		  case 1:
			  statusGameString = "15";
		    break;
		  case 2:
			  statusGameString = "30";
			  break;
		  case 3:
			  statusGameString = "40";
			  break;
		  case 4:
			  statusGameString = "DEUCE";
			  break;
		  case 5:
			  statusGameString = "ADVANTAGE";
			  break;
		}
		return statusGameString;	
	}
	
	public static String showScore(Player p1, Player p2){			
		String message = "";
		List<Integer>listP1 = p1.getListScoreGame();
		List<Integer>listP2 = p2.getListScoreGame();
		int maxNbreSet = p1.getNbrSet() + p2.getNbrSet();
		
		if(p1.getNbrSet() > 0 || p2.getNbrSet() > 0 ){				
			for(int i=0; i < maxNbreSet; i++){	
				message = message + "(" + listP1.get(i) + "-" +  listP2.get(i) + ")";
			}						
		}
		
		if(maxNbreSet < 5 && (p1.getNbrSet() <3 && p2.getNbrSet() <3)) {
			message = message + "(" + p1.getNbrGame() + "-" +  p2.getNbrGame() + ")";
		}
		
		return message;
	}
}
