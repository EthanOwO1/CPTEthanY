// Ethan Y
// Math Training Game
// 2024-01-21
// Version 1.1

// Importing Libraries
import arc.*;
import java.awt.image.*;
import java.awt.Font;
import java.awt.Color;


public class MathTrainingGame{	
	
	static String strName = "";
	
	public static void main(String[] args){
		Console con = new Console("Math Training Game", 1280, 720);		
		
		BufferedImage imgbackground = con.loadImage("background.png");
		
		con.drawImage(imgbackground, 0, 0);
		Font font = con.loadFont("Arial Black.ttf", 28);
		con.setTextFont(font);

		// Main Screen of the Math Training Game
		while(true){
			
			con.println();
			con.println();
			con.println();
			con.println();

			con.println("                                             Welcome to Math Training Game");	
			con.println();
			con.println("		  What would you like to do?");
			con.println();
			con.println("	            (p: play game, l: leaderboard, h: help, q: quit)");
			con.println();			
			
			String strDecision = con.readLine();
			
			con.clear();
			
			// The Quit Screen of the Math Training Game
			if(strDecision.equalsIgnoreCase("q")){
				
				con.println("Thank you for playing! See you next time!");
				con.sleep(3000);
				con.closeConsole();
				
			// The Leaderboard Screen of the Math Training Game
			} else if(strDecision.equalsIgnoreCase("l")){
				TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
				
				String strName = "";
				String strTestType = "";
				String strPercentage = "";
				int intResults = 0;
				
				con.println("This is the leaderboard");
				con.println();
				con.println("Name	|Test Type	|Winning Percentage");
				con.println("------------------------------------------------------------------------------------------------");
				
				while(leaderboard.eof() == false){
					strName = leaderboard.readLine();
					strTestType = leaderboard.readLine();
					strPercentage = leaderboard.readLine();
					intResults += 1;
				}
				
				leaderboard.close();
				
				String strLeaderboard[][];
				strLeaderboard = new String[intResults][3];
				
				leaderboard = new TextInputFile("leaderboard.txt");
				
				while(leaderboard.eof() == false){
					
					int intRow;
					
					for(intRow = 0; intRow < intResults; intRow++){
						
						strLeaderboard[intRow][0] = leaderboard.readLine();
						strLeaderboard[intRow][1] = leaderboard.readLine();
						strLeaderboard[intRow][2] = leaderboard.readLine();
					}
				}
				String strNames;
				String strTestTypes;
				String strAccuracy;
				int intRow;
				int intRow2;
				
				// Bubble sorting
				for(intRow2 = 0; intRow2 < intResults - 1; intRow2++){
	
					for(intRow = 0; intRow < intResults - 1 - intRow2; intRow++){
						// Bubble sort. If right is bigger than left
						
						if(Double.parseDouble(strLeaderboard[intRow][2]) < Double.parseDouble(strLeaderboard[intRow + 1][2])){
							
							// Take the left item
							strNames = strLeaderboard[intRow][0];
							strTestType = strLeaderboard[intRow][1];
							strAccuracy = strLeaderboard[intRow][2];
							
							// Right item moves to the left
							strLeaderboard[intRow][0] = strLeaderboard[intRow + 1][0];
							strLeaderboard[intRow][1] = strLeaderboard[intRow + 1][1];
							strLeaderboard[intRow][2] = strLeaderboard[intRow + 1][2];
							
							// Put temporary value on the right
							strLeaderboard[intRow + 1][0] = strNames;
							strLeaderboard[intRow + 1][1] = strTestType;
							strLeaderboard[intRow + 1][2] = strAccuracy;
						}
					}
				}
				
				int intLoop;
				
				// Prints out all of the user records
				for(intLoop = 0; intLoop < intResults; intLoop++){
					con.println(strLeaderboard[intLoop][0] + "	|" + strLeaderboard[intLoop][1] + "	|" + strLeaderboard[intLoop][2]);
				
				}
				con.println();
				con.println("Do you want to go back to main menu?");
				String strBack = con.readLine();
				con.clear();
				
			// The Help Screen of the Math Training Game
			} else if(strDecision.equalsIgnoreCase("h")){
				con.println("--- Help Menu ---");
				con.sleep(1000);
				con.println("How to play: ");
				con.sleep(1000);
				con.println("Choose any test type to start solving.");
				con.sleep(1000);
				con.println("After choosing the topic, solve all the questions.");
				con.sleep(1000);
				con.println("The person with the highest accuracy will be 1st in the leaderboard");
				con.sleep(1000);
				con.println("Try your best and aim for the top.");
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
				
				// All the test types that the user can choose from. Shown in the form of buttons.
				con.setDrawColor(new Color(0, 0, 0, 50));

				con.drawRoundRect(50, 400, 250, 100, 10, 10);
				con.fillRoundRect(50, 400, 250, 100, 10, 10);

				con.drawRoundRect(350, 400, 250, 100, 10, 10);
				con.fillRoundRect(350, 400, 250, 100, 10, 10);

				con.drawRoundRect(650, 400, 250, 100, 10, 10);
				con.fillRoundRect(650, 400, 250, 100, 10, 10);

				con.drawRoundRect(950, 400, 250, 100, 10, 10);
				con.fillRoundRect(950, 400, 250, 100, 10, 10);
				
				con.println();
				con.println();
				con.println();
				con.println();
				con.println();
				con.println();
				con.println();
				con.println();
				con.println();

				
				while(tests.eof() == false){
					con.print("             " + tests.readLine() + "        ");
				}
				
				while(true){
					if(con.currentMouseButton() == 1) {
						int mouseX = con.currentMouseX();
						int mouseY = con.currentMouseY();

						// Open Linear Quiz if mouse is in the designated area
						if (mouseX >= 50 && mouseX <= 300 && mouseY >= 400 && mouseY <= 500) {
							con.clear();
							con.drawImage(imgbackground, 0, 0);
							MathTrainingTests.linearTest(con);
							break;
							
						}
						// Open Algebra Quiz if mouse is in the designated area
						if (mouseX >= 350 && mouseX <= 600 && mouseY >= 400 && mouseY <= 500) {
							con.clear();
							con.drawImage(imgbackground, 0, 0);
							MathTrainingTests.algebraTest(con);
							break;
							
						}
						// Open Patterns Quiz if mouse is in the designated area
						if (mouseX >= 650 && mouseX <= 900 && mouseY >= 400 && mouseY <= 500) {
							con.clear();
							con.drawImage(imgbackground, 0, 0);
							MathTrainingTests.patternsTest(con);
							break;
							
						}
						// Open Area Quiz if mouse is in the designated area
						if (mouseX >= 950 && mouseX <= 1200 && mouseY >= 400 && mouseY <= 500) {
							con.clear();
							con.drawImage(imgbackground, 0, 0);
							MathTrainingTests.areaTest(con);
							break;
							
						}
					}
				}
			}
			
			// My Secret Menu
			else if(strDecision.equalsIgnoreCase("Secret")){
				con.println("Welcome to our secret menu");
				con.println("Did you know that if we removed the wings from a fly, it becomes a walk?");
				con.println("*laughs");
				con.sleep(3000);
				con.println("Return back to main menu?");
				String strBack = con.readLine();
				con.clear();
				
			}
			// If no commands found, return back to main menu.
			else{
				con.println("Cannot find the command");
				con.println("Return back to main menu?");
				String strBack = con.readLine();
				con.clear();
			}
		
		}
	}
}
