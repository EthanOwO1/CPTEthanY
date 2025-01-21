// Ethan Y
// Math Training Game
// 2024-01-21
// Version 1.19

// Importing Libraries
import arc.*;
import java.awt.image.*;
import java.awt.Font;
import java.awt.Color;

public class MathTrainingGame{	
	
	// Declaring Global Variables
	static String strName = "";
	static boolean blnCheat = false;
	
	public static void main(String[] args){
		Console con = new Console("Math Training Game", 1280, 720);		

		// Main Screen of the Math Training Game
		while(true){
			
			// Creating a background image
			BufferedImage imgbackground = con.loadImage("background.png");
			con.drawImage(imgbackground, 0, 0);
			con.clear();
			
			// Creating buttons
			con.setDrawColor(new Color(0, 0, 0, 50));
			
			con.drawRoundRect(1100, 0, 180, 80, 10, 10);
			con.fillRoundRect(1100, 0, 180, 80, 10, 10);
			
			con.drawRoundRect(500, 320, 280, 50, 10, 10);
			con.fillRoundRect(500, 320, 280, 50, 10, 10);
			
			con.drawRoundRect(500, 400, 280, 50, 10, 10);
			con.fillRoundRect(500, 400, 280, 50, 10, 10);
			
			con.drawRoundRect(500, 480, 280, 50, 10, 10);
			con.fillRoundRect(500, 480, 280, 50, 10, 10);
			
			con.drawRoundRect(500, 560, 280, 50, 10, 10);
			con.fillRoundRect(500, 560, 280, 50, 10, 10);
			
			con.setDrawColor(new Color(255, 255, 255, 40));
			
			con.drawRoundRect(500, 640, 280, 50, 10, 10);
			con.fillRoundRect(500, 640, 280, 50, 10, 10);	
			
			// Printing Text for the main menu
			con.setDrawColor(Color.white);

			Font fontSmall = con.loadFont("Arial Black.ttf", 28);
			con.setDrawFont(fontSmall);
			
			con.drawString("Codes", 1130, 10);	

			Font fontLarge = con.loadFont("Arial Black.ttf", 42);
			con.setDrawFont(fontLarge);

			con.drawString("Welcome to Math Training Game", 280, 50);

			fontSmall = con.loadFont("Arial Black.ttf", 28);
			con.setDrawFont(fontSmall);

			con.drawString("What would you like to do?", 450, 120);
			
			con.drawString("Play Game", 510, 320);

			con.drawString("Leaderboard", 510, 400);
			
			con.drawString("Help", 510, 480);
			
			con.drawString("Quit", 510, 560);
			
			// Debugging
			System.out.println("Able to display main screen");			
			
			con.setTextFont(fontSmall);
			
			while(true){
				if(con.currentMouseButton() == 1) {
					// Finding the location of the mouse if it pressed one of the buttons on the screen
					int intMouseX = con.currentMouseX();
					int intMouseY = con.currentMouseY();				
					
					// The Play Game Screen 
					if(intMouseX >= 500 && intMouseX <= 780 && intMouseY >= 320 && intMouseY <= 370){
						TextInputFile tests = new TextInputFile("tests.txt");
						
						con.clear();
						con.drawImage(imgbackground, 0, 0);
						
						// User inputting their names
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
						con.println();

						con.drawRoundRect(350, 400, 250, 100, 10, 10);
						con.fillRoundRect(350, 400, 250, 100, 10, 10);
						con.println();

						con.drawRoundRect(650, 400, 250, 100, 10, 10);
						con.fillRoundRect(650, 400, 250, 100, 10, 10);
						con.println();

						con.drawRoundRect(950, 400, 250, 100, 10, 10);
						con.fillRoundRect(950, 400, 250, 100, 10, 10);
						con.println();
						
						con.drawRoundRect(480, 550, 380, 100, 10, 10);
						con.fillRoundRect(480, 550, 380, 100, 10, 10);
						con.println();

						con.setDrawColor(Color.white);
						
						con.drawString("Return to Main Menu", 510, 575);

						int intX = 120;
						
						while(tests.eof() == false){
							con.drawString(tests.readLine(), intX, 420);
							intX += 300;
						}
						
						while(true){
							if(con.currentMouseButton() == 1) {
								intMouseX = con.currentMouseX();
								intMouseY = con.currentMouseY();

								// Open Linear Test if mouse is in the designated area
								if (intMouseX >= 50 && intMouseX <= 300 && intMouseY >= 400 && intMouseY <= 500) {
									con.clear();		
									con.drawImage(imgbackground, 0, 0);
									MathTrainingTests.linearTest(con);
									
									// Debugging
									System.out.println("Able to execute Linear Quiz");	
									
									break;
									
								}
								// Open Algebra test if mouse is in the designated area
								if (intMouseX >= 350 && intMouseX <= 600 && intMouseY >= 400 && intMouseY <= 500) {
									con.clear();
									con.drawImage(imgbackground, 0, 0);
									MathTrainingTests.algebraTest(con);
									
									// Debugging
									System.out.println("Able to execute Algebra Quiz");	
									
									break;
									
								}
								// Open Patterns Test if mouse is in the designated area
								if (intMouseX >= 650 && intMouseX <= 900 && intMouseY >= 400 && intMouseY <= 500) {
									con.clear();
									con.drawImage(imgbackground, 0, 0);
									MathTrainingTests.patternsTest(con);
									
									// Debugging
									System.out.println("Able to execute Patterns Quiz");	
									
									break;
									
								}
								// Open Area Test if mouse is in the designated area
								if (intMouseX >= 950 && intMouseX <= 1200 && intMouseY >= 400 && intMouseY <= 500) {
									con.clear();
									con.drawImage(imgbackground, 0, 0);
									MathTrainingTests.areaTest(con);
									
									// Debugging
									System.out.println("Able to execute Area Quiz");	
									
									break;
									
								}
								// If mouse clicks in designated area, return back to main menu
								if (intMouseX >= 480 && intMouseX <= 860 && intMouseY >= 550 && intMouseY <= 650) {
									break;
									
								}
							}
						}
						break;
						
					}
						
					// The Leaderboard Screen of the Math Training Game
					else if(intMouseX >= 500 && intMouseX <= 780 && intMouseY >= 400 && intMouseY <= 450){
						TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
						
						con.clear();
						con.drawImage(imgbackground, 0, 0);
						
						// Variable Declaration/Initialization
						String strName = "";
						String strTestType = "";
						String strPercentage = "";
						int intTestCount = 0;
						
						con.println("This is the leaderboard");
						con.println();
						con.println("Name	|Test Type	|Winning Percentage");
						con.println("------------------------------------------------------------------------------------------------");
						
						// Opening leaderboard.txt to access the results from the tests
						while(leaderboard.eof() == false){
							strName = leaderboard.readLine();
							strTestType = leaderboard.readLine();
							strPercentage = leaderboard.readLine();
							intTestCount += 1;
						}
						leaderboard.close();
						
						String strLeaderboard[][];
						strLeaderboard = new String[intTestCount][3];
						
						leaderboard = new TextInputFile("leaderboard.txt");
						while(leaderboard.eof() == false){
							int intRow;
							
							for(intRow = 0; intRow < intTestCount; intRow++){
								
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
						
						// Bubble sorting: Sorting the test results from highest to lowest.
						for(intRow2 = 0; intRow2 < intTestCount - 1; intRow2++){
			
							for(intRow = 0; intRow < intTestCount - 1 - intRow2; intRow++){
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
						
						// Prints out all of the test records
						for(intLoop = 0; intLoop < intTestCount; intLoop++){
							con.println(strLeaderboard[intLoop][0] + "	|" + strLeaderboard[intLoop][1] + "	|" + strLeaderboard[intLoop][2]);
						
						}
						con.println();
						con.println("Press any key if you want to go back to main menu.");
						char chrBack = con.getChar();
						con.clear();
						
						break;
								
					} 
					
					// The Help Screen of the Math Training Game
					else if(intMouseX >= 500 && intMouseX <= 780 && intMouseY >= 480 && intMouseY <= 530){
						
						con.clear();
						con.drawImage(imgbackground, 0, 0);

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
						
						con.println("Press any key if you want to go back to main menu.");
						char chrBack = con.getChar();
						con.clear();
						
						break;
						
					}
					
					// The Quit Screen of the Math Training Game
					else if(intMouseX >= 500 && intMouseX <= 780 && intMouseY >= 560 && intMouseY <= 610){
						
						con.clear();
						con.drawImage(imgbackground, 0, 0);
						
						con.println("Thank you for playing! See you next time!");
						con.sleep(3000);
						con.closeConsole();
						
					}
					
					// My Secret Menu
					else if(intMouseX >= 500 && intMouseX <= 780 && intMouseY >= 640 && intMouseY <= 690){
						
						con.clear();
						con.drawImage(imgbackground, 0, 0);
						
						con.println("Welcome to our secret menu");
						con.println("Did you know that if we removed the wings from a fly, it becomes a walk?");
						con.println("*laughs");
						con.println();
						con.sleep(3000);
						con.println("Press any key if you want to go back to main menu.");
						char chrBack = con.getChar();
						con.clear();
						
						break;
						
					}
					
					// My Codes
					else if(intMouseX >= 1100 && intMouseX <= 1280 && intMouseY >= 0 && intMouseY <= 80){
						
						con.clear();
						con.drawImage(imgbackground, 0, 0);
						
						con.println("Enter the secret code");
						String strCode = con.readLine();
						
						if(strCode.equalsIgnoreCase("statitan")){
							blnCheat = true;
							con.println("Code successfully redeemed");
						} else {
							con.println("Failed to find cheat code");
						}
						
						con.sleep(2000);
						
						break;
						
					}
				}
			}
		}
	}
}
