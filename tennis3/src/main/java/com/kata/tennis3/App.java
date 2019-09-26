package com.kata.tennis3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		System.out.println( "*******************************************" );
        System.out.println( "*************  KATA TENNIS 2****************" );
        System.out.println( "*******************************************" );
        Scanner sc = new Scanner(System.in);
        
        	
        	System.out.println( "Nouvelle Partie : Pour jouer tapez [J]" );
        	String choice = sc.nextLine();

        	String isWinner;
        	List<Integer>listScoreGameP1 = new ArrayList<>();
        	List<Integer>listScoreGameP2 = new ArrayList<>();
        	
        	Player p1 = new Player("Player1", null, 0, 0, listScoreGameP1, 0, false, "In progress");
    		Player p2 = new Player("Player2", null, 0, 0, listScoreGameP2, 0, false, "In progress");
        	
        	if(!choice.equals("J")){
        		System.out.println( " Bad choice!" );
        		System.exit(0);
        	}
        	
        	Tennis tennis = new Tennis();
        	
        	//Tant que le match n'est pas terminé!
        	while(!p1.isMatchWinner() && !p2.isMatchWinner()) {
        		System.out.println( "=> New service <="  );
        		System.out.println( p1.getName() +" is the service winner?  (Y/N) : "  );
        		isWinner = sc.nextLine();        		
        		
        		if(isWinner.equals("Y")) {
        			p1.setCurrentService(CurrentService.W.toString());
        			p2.setCurrentService(CurrentService.L.toString());
        			tennis.changeStatusStandard(p1, p2);
        		}else {
        			p1.setCurrentService(CurrentService.L.toString());
        			p2.setCurrentService(CurrentService.W.toString());
        			tennis.changeStatusStandard(p1, p2);
        		}
        		
        		//showResume
			tennis.showMessage(()-> { 	
			  	System.out.println("Player 1 : " + p1.getName());
			  	System.out.println("Player 2 : " + p2.getName());
			  	System.out.println("Score : " + IParameters.showScore(p1, p2));
			  	if(p1.getMatchStatus().equals("In progress")){ 
			  		System.out.println("Current game status : " + IParameters.convertStatusGameToString(p1.getCurrentGameStatus()) + "-" + IParameters.convertStatusGameToString(p2.getCurrentGameStatus()));
			  	}			  	
			  	System.out.println("Match status: " + p1.getMatchStatus());
			});
			
        	}
        	
        	System.out.println( "********************************************" );
    		System.out.println( "*************** FIN DU JEU *****************" );
    		System.out.println( "********************************************" );
        	
    }
}
