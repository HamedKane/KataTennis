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
	
}

