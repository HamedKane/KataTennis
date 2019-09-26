package com.kata.tennis3;

import java.util.Scanner;

import com.kata.tennis3.Tennis;
import com.kata.tennis3.IMessage;
import com.kata.tennis3.IParameters;
import com.kata.tennis3.CurrentService;
import com.kata.tennis3.Player;

public class Tennis {

	public void ManageCurrentGameStatus(Player p1 , Player p2){
		changeStatusStandard( p1, p2) ;
	}
	
	public void changeStatusStandard(Player p1, Player p2) {
		if(p1.getCurrentService().equals(CurrentService.W.toString())){
			switch(p1.getCurrentGameStatus()) {
			  case 0:
			    p1.setCurrentGameStatus(IParameters.GAME_STATUS_15);
			    break;
			  case 1:
				  p1.setCurrentGameStatus(IParameters.GAME_STATUS_30);
			    break;
			  case 2:
				  p1.setCurrentGameStatus(IParameters.GAME_STATUS_40);
				  if (p1.getCurrentGameStatus() == IParameters.GAME_STATUS_40 && p2.getCurrentGameStatus() == IParameters.GAME_STATUS_40){
					  p1.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
					  p2.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
				  }
				break;
			  case 3:
				  	 manageGame(p1,p2);
				  	 manageSet(p1,p2);
				  	 
				  	 p1.setCurrentGameStatus(0);
				  	 p2.setCurrentGameStatus(0);
				break;
			  case 4:
				    //DEUCE CASE
				  	p1.setCurrentGameStatus(IParameters.GAME_STATUS_ADVANTAGE);
				  	if(p2.getCurrentGameStatus() == IParameters.GAME_STATUS_ADVANTAGE) {
				  		p2.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
				  	}
				break;
			  case 5:
				  	 manageGame(p1,p2);
				  	 manageSet(p1,p2);
				  	 
				  	 p1.setCurrentGameStatus(0);
				  	 p2.setCurrentGameStatus(0);
				break;
			  default:		    
			}
		}else if(p2.getCurrentService().equals(CurrentService.W.toString())) {
			switch(p2.getCurrentGameStatus()) {
			  case 0:
			    p2.setCurrentGameStatus(IParameters.GAME_STATUS_15);
			    break;
			  case 1:
				  p2.setCurrentGameStatus(IParameters.GAME_STATUS_30);
			    break;
			  case 2:
				  p2.setCurrentGameStatus(IParameters.GAME_STATUS_40);
				  if (p2.getCurrentGameStatus() == IParameters.GAME_STATUS_40 && p1.getCurrentGameStatus() == IParameters.GAME_STATUS_40){
					  p2.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
					  p1.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
				  }
				break;
			  case 3:
				     manageGame(p1,p2);
				     manageSet(p1,p2);
				     
				  	 p1.setCurrentGameStatus(0);
				  	 p2.setCurrentGameStatus(0);
				break;
			  case 4:
				    //DEUCE CASE
				  	p2.setCurrentGameStatus(IParameters.GAME_STATUS_ADVANTAGE);
				  	if(p1.getCurrentGameStatus() == IParameters.GAME_STATUS_ADVANTAGE) {
				  		p1.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
				  	}
				break;
			  case 5:
				     manageGame(p1,p2);
				     manageSet(p1,p2);
				     
				  	 p2.setCurrentGameStatus(0);
				  	 p1.setCurrentGameStatus(0);
				break;
			  default:		    
			}
		}
	}
	
	public void manageGame(Player p1, Player p2) {		
		if(p1.getCurrentService().equals(CurrentService.W.toString())) {
			p1.setNbrGame(p1.getNbrGame() + 1);
		}else if(p2.getCurrentService().equals(CurrentService.W.toString())) {
			p2.setNbrGame(p2.getNbrGame() + 1);
		}		
	}
	
	public void manageSet(Player p1, Player p2) {	
		
		Tennis tennis = new Tennis();

		if(p1.getNbrGame() == 6 && p2.getNbrGame() == 6) {				
			newServiceTieBreak(	p1, 	p2, tennis);	
		}else{					
			if((p1.getNbrGame() > p2.getNbrGame()) && (p1.getNbrGame()>=6) && (p1.getNbrGame()-p2.getNbrGame()>=2)) {
				p1.setNbrSet(p1.getNbrSet() + 1);
				
				p1.getListScoreGame().add(p1.getNbrGame());
				p1.setNbrGame(0);			
				p2.getListScoreGame().add(p2.getNbrGame());
				p2.setNbrGame(0);
				
			}else if((p2.getNbrGame() > p1.getNbrGame()) && (p2.getNbrGame()>=6) && (p2.getNbrGame()-p1.getNbrGame()>=2)) {
				p2.setNbrSet(p2.getNbrSet() + 1);
				
				p1.getListScoreGame().add(p1.getNbrGame());
				p1.setNbrGame(0);			
				p2.getListScoreGame().add(p2.getNbrGame());
				p2.setNbrGame(0);
			}
			
		}
	}
	
	
	public void newServiceTieBreak(	Player p1, 	Player p2, Tennis tennis) {
		
		String isWinner;
		Scanner sc = new Scanner(System.in);
		
		System.out.println( "!!!!!!!!!!!!! New TIE-BREAK service  !!!!!!!!!!!!!!!"  );
		System.out.println( p1.getName() +" is the TIE-BREAK service winner?  (Y/N) : "  );
		isWinner = sc.nextLine();        		
	
		if(isWinner.equals("Y")) {
			p1.setNbrGame(p1.getNbrGame() + 1);
			p1.setNbrSet(p1.getNbrSet() + 1);
			
			p1.getListScoreGame().add(p1.getNbrGame());
			p1.setNbrGame(0);			
			p2.getListScoreGame().add(p2.getNbrGame());
			p2.setNbrGame(0);
		}else {
			p2.setNbrGame(p2.getNbrGame() + 1);
			p2.setNbrSet(p2.getNbrSet() + 1);
			p1.getListScoreGame().add(p1.getNbrGame());
			p1.setNbrGame(0);			
			p2.getListScoreGame().add(p2.getNbrGame());
			p2.setNbrGame(0);
		}
		
		System.out.println( "!!!!!!!!!!!!! End TIE-BREAK service  !!!!!!!!!!!!!!!"  );
		
	}
	
	public void manageMatch(Player p1, Player p2) {		
		if(p1.getNbrSet() == 3) {
			p1.setMatchWinner(true);
			p1.setMatchStatus(p1.getName() + " wins.");
		}else if(p2.getNbrSet() == 3) {
			p2.setMatchWinner(true);
			p1.setMatchStatus(p2.getName() + " wins.");
		}		
	}
	
}

