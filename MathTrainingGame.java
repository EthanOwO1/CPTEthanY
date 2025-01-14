import arc.*;

public class MathTrainingGame{
	public static void main(String[] args){
		Console con = new Console("Math Training Game", 1280, 720);
		
		// Variables and Initialization
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		int intAnswer = 0;
		double dblAnswer = 0.0;
		String strAnswer = "";
		int intCorrectAnswer = 0;
		int intNumQuestions = 0;
		double dblPercentage = 0.0;
		int intQuestions = 0;
		
		
		
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
				con.println("This is the leaderboard");
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
				con.println("Please enter your name: ");
				String strName = con.readLine();
				con.clear();
				
				con.println("Hi " + strName);
				con.sleep(1000);
				con.println("Welcome to our game! Please choose which type of quiz you would like to do?");
				con.println("(Linear, Algebra, Patterns, Area)");
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
