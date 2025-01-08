import arc.*;

public class MathTrainingGame{
	public static void main(String[] args){
		Console con = new Console("Math Training Game", 1280, 720);
		
		// Variables and Initialization
		String strQuestion = "";
		int intAnswer = 0;
		double dblAnswer = 0.0;
		String strAnswer = "";
		int intCorrectAnswer = 0;
		int intNumQuestions = 0;
		double dblPercentage = 0.0;
		int intQuestions = 0;
		
		// Creating an array to randomize the questions
		String strRandomNum[][];
		
		
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
					TextInputFile linear = new TextInputFile("linear.txt");
					strRandomNum = new String[intQuestions][5];

					
					while(linear.eof() == false){
						intQuestions += 1;
						String strRandomNum1 = Integer.toString((int)(Math.random() * intQuestions + 1));
						
						int intRow;
						
						for(intRow = 0; intRow < intQuestions; intRow++){
							strRandomNum[intQuestions][0] = linear.readLine();
							strRandomNum[intQuestions][1] = linear.readLine();
							strRandomNum[intQuestions][2] = linear.readLine();
							strRandomNum[intQuestions][3] = linear.readLine();
							strRandomNum[intQuestions][4] = strRandomNum1;
						}
					}
					
					linear.close();
					
					// Bubble Sort 
					String strTempQuestion;
					String strTempAns1;
					String strTempAns2;
					String strTempAns3;
					String strTempRandomNum;
					int intRow2;
					int intRow3;
					
					for(intRow3 = 0; intRow3 < 10-1; intRow3++){
						
						for(intRow2 = 0; intRow2 < 10 - 1 - intRow3; intRow2++){
							// Bubble sort. If left is bigger than right
							
							if(Integer.parseInt(strRandomNum[intRow2][5]) > Integer.parseInt(strRandomNum[intRow2 + 1][5])){
								
								// Take the left item
								strTempQuestion = strRandomNum[intQuestions][0];
								strTempAns1 = strRandomNum[intQuestions][1];
								strTempAns2 = strRandomNum[intQuestions][2];
								strTempAns3 = strRandomNum[intQuestions][3];
								
								// Right item moves to the left
								strRandomNum[intQuestions][0] = strRandomNum[intQuestions + 1][0];
								strRandomNum[intQuestions][1] = strRandomNum[intQuestions + 1][1];
								strRandomNum[intQuestions][2] = strRandomNum[intQuestions + 1][2];
								strRandomNum[intQuestions][3] = strRandomNum[intQuestions + 1][3];
								
								// Put temporary value on the right
								strRandomNum[intQuestions + 1][0] = strTempQuestion;
								strRandomNum[intQuestions + 1][1] = strTempAns1;
								strRandomNum[intQuestions + 1][2] = strTempAns2;
								strRandomNum[intQuestions + 1][3] = strTempAns3;
							}
						}
					}
					
					int intLoop;
					
					for(intLoop = 0; intLoop < intQuestions; intLoop++){
					
						con.println("Question: ");
						con.println(strQuestion);
						String strResponse = con.readLine();
					
						if(strResponse.equalsIgnoreCase(strResponse) || 
						Integer.parseInt(strResponse) == intAnswer ||
						Double.parseDouble(strResponse) == dblAnswer
						){
						
							con.println("Congrats! You got the correct answer.");
							intCorrectAnswer += 1;
							
							con.sleep(3000);
						
						} else {
							con.println("You got the wrong answer. It should either be: " + strAnswer + ", " + intAnswer + ", " + dblAnswer);
							con.sleep(3000);
						}
						
						intNumQuestions += 1;
						dblPercentage = intCorrectAnswer / intNumQuestions;
						con.clear();
						
					}
					
					// Calculating the percentage of answers
					con.println("Number of correct answer: " + intCorrectAnswer);
					con.sleep(2000);
					con.println("Thanks for playing!");
					con.println("Return back to main menu?");
					String strBack = con.readLine();
					con.clear();

				}
				
				// Algebra Math Practice
				if(strType.equalsIgnoreCase("algebra")){
					TextInputFile algebra = new TextInputFile("algebra.txt");
					
					while(algebra.eof() == false){
						strQuestion = algebra.readLine();
						intAnswer = algebra.readInt();
						dblAnswer = algebra.readDouble();
						strAnswer = algebra.readLine();
						
						con.println("Question: ");
						con.println(strQuestion);
						String strResponse = con.readLine();
						
						if(strResponse.equalsIgnoreCase(strResponse) || 
						Integer.parseInt(strResponse) == intAnswer ||
						Double.parseDouble(strResponse) == dblAnswer){
						
							con.println("Congrats! You got the correct answer.");
							intCorrectAnswer += 1;
							
							con.sleep(3000);
						
						} else {
							con.println("You got the wrong answer. It should either be: " + strAnswer + ", " + intAnswer + ", " + dblAnswer);
							con.sleep(3000);
						}
						
						intNumQuestions += 1;
						dblPercentage = intCorrectAnswer / intNumQuestions;
						con.clear();
					}
					
					// Calculating the percentage of answers
					con.println("Number of correct answer: " + intCorrectAnswer);
					con.sleep(2000);
					con.println("Thanks for playing!");
					con.println("Return back to main menu?");
					String strBack = con.readLine();
					con.clear();
				
				}
			
				// Patterns Math Practice
				if(strType.equalsIgnoreCase("patterns")){
					TextInputFile patterns = new TextInputFile("patterns.txt");
					
					while(patterns.eof() == false){
						strQuestion = patterns.readLine();
						intAnswer = patterns.readInt();
						dblAnswer = patterns.readDouble();
						strAnswer = patterns.readLine();
						
						con.println("Question: ");
						con.println(strQuestion);
						String strResponse = con.readLine();
						
						if(strResponse.equalsIgnoreCase(strAnswer)){
						
							con.println("Congrats! You got the correct answer.");
							intCorrectAnswer += 1;
							
							con.sleep(3000);
						
						} else {
							con.println("You got the wrong answer. It should either be: " + strAnswer + ", " + intAnswer + ", " + dblAnswer);
							con.sleep(3000);
						}
						
						intNumQuestions += 1;
						dblPercentage = intCorrectAnswer / intNumQuestions;
						con.clear();
					}
					
					// Calculating the percentage of answers
					con.println("Number of correct answer: " + intCorrectAnswer);
					con.sleep(2000);
					con.println("Thanks for playing!");
					con.println("Return back to main menu?");
					String strBack = con.readLine();
					con.clear();
				}	

				// Area Math Practice
				if(strType.equalsIgnoreCase("area")){
					TextInputFile area = new TextInputFile("area.txt");
					
					while(area.eof() == false){
						strQuestion = area.readLine();
						intAnswer = area.readInt();
						dblAnswer = area.readDouble();
						strAnswer = area.readLine();
						
						con.println("Question: ");
						con.println(strQuestion);
						String strResponse = con.readLine();
						
						if(strResponse.equalsIgnoreCase(strAnswer)){
						
							con.println("Congrats! You got the correct answer.");
							intCorrectAnswer += 1;
							
							con.sleep(3000);
						
						} else {
							con.println("You got the wrong answer. It should either be: " + strAnswer + ", " + intAnswer + ", " + dblAnswer);
							con.sleep(3000);
						}
						
						intNumQuestions += 1;
						dblPercentage = intCorrectAnswer / intNumQuestions;
						con.clear();
					}
					
					// Calculating the percentage of answers
					con.println("Number of correct answer: " + intCorrectAnswer);
					con.sleep(2000);
					con.println("Thanks for playing!");
					con.println("Return back to main menu?");
					String strBack = con.readLine();
					con.clear();

				}
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
