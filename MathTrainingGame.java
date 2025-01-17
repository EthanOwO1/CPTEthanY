// Ethan Y
// Math Training Game
// 2024-01-21
// Version 1.1

import arc.*;

public class MathTrainingGame{	
	
	static String strName = "";
	
	public static void main(String[] args){
		Console con = new Console("Math Training Game", 1280, 720);
		
		// Main Screen of the Math Training Game
		while(true){
			con.println("Welcome to Math Training Game");
			con.println("What would you like to do? (p: play game, l: leaderboard, h: help, q: quit) ");
			String strDecision = con.readLine();
			
			con.clear();
			
			// The Quit Screen of the Math Training Game
			if(strDecision.equalsIgnoreCase("q")){
				con.println("Thank you for playing! See you next time!");
				con.sleep(3000);
				con.closeConsole();
				
			// The Leaderbaord Screen of the Math Training Game
			} else if(strDecision.equalsIgnoreCase("l")){
				TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
				
				String strName = "";
				String strTestType = "";
				String strPercentage = "";
				
				con.println("This is the leaderboard");
				con.println();
				con.println("Name		|		Test Type		|	Winning Percentage");
				con.println("--------------------------------------------------------------------------------");
				
				while(leaderboard.eof() == false){
					strName = leaderboard.readLine();
					strTestType = leaderboard.readLine();
					strPercentage = leaderboard.readLine();
					
					con.println(strName + "		|" + strTestType + "					|" + strPercentage);
					
				}
				
				con.println();
				con.println("Do you want to go back to main menu?");
				String strBack = con.readLine();
				con.clear();
				
			// The Help Screen of the Math Training Game
			} else if(strDecision.equalsIgnoreCase("h")){
				con.println("Welcome to Math Training Game.");
				con.sleep(1000);
				con.println("In this program, you will be able to choose any subject to test. ");
				con.sleep(1000);
				con.println("After choosing the topic, you will have to answer questions which will be shown on the leaderboards.");
				con.sleep(1000);
				con.println("Otherwise, have fun!!!");
				
				con.println("Do you want to go back to main menu?");
				String strBack = con.readLine();
				con.clear();
				
			// The Play Game Screen 
			} else if(strDecision.equalsIgnoreCase("p")){
				TextInputFile tests = new TextInputFile("tests.txt");
				
				con.println("Please enter your name: ");
				strName = con.readLine();
				con.clear();
				
				con.println("Hi " + strName);
				con.sleep(1000);
				con.println("Welcome to our game! Please choose which type of quiz you would like to do?");

				while(tests.eof() == false){
					con.print(tests.readLine() + ", ");
				}	
				
				con.println();
				String strType = con.readLine();
				con.clear();
				
				// Linear Quiz
				if(strType.equalsIgnoreCase("linear")){
					MathTrainingTests.linearTest(con);
				}
				
				
				// Algebra Math Practice
				if(strType.equalsIgnoreCase("algebra")){
					MathTrainingTests.algebraTest(con);
				}
			
				// Patterns Math Practice
				if(strType.equalsIgnoreCase("algebra")){
					MathTrainingTests.patternsTest(con);
				}	

				// Area Math Practice
				if(strType.equalsIgnoreCase("area")){
					MathTrainingTests.areaTest(con);
				}
			}
			
			else if(strDecision.equalsIgnoreCase("Secret")){
				con.println("Welcome to our secret menu");
				con.println("Did you know that if we removed the wings from a fly, it becomes a walk?");
				con.println("😂😂😂");
				con.sleep(3000);
				con.println("Return back to main menu?");
				String strBack = con.readLine();
				con.clear();
				
			}
			
			else{
				con.println("Cannot find the command");
				con.println("Return back to main menu?");
				String strBack = con.readLine();
				con.clear();
			}
		
		}
	}
}
