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

		
		// Main Screen of the Math Training Game
		while(true){
			con.println("Welcome to Math Training Game");
			con.println("What would you like to do? (Play game, Leaderboard, Help, Quit) ");
			String strDecision = con.readLine();
			
			con.clear();
			
			// The Quit Screen of the Math Training Game
			if(strDecision.equalsIgnoreCase("quit")){
				con.println("Thank you for playing! See you next time!");
				con.sleep(3000);
				con.closeConsole();
				
			// The Leaderbaord Screen of the Math Training Game
			} else if(strDecision.equalsIgnoreCase("leaderboard")){
				con.println("This is the leaderboard");
				con.println("Do you want to go back to main menu?");
				String strBack = con.readLine();
				con.clear();
				
			// The Help Screen of the Math Training Game
			} else if(strDecision.equalsIgnoreCase("help")){
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
			} else {
				con.println("Please enter your name: ");
				String strName = con.readLine();
				con.clear();
				
				con.println("Hi " + strName);
				con.sleep(1000);
				con.println("Welcome to our game! Please choose which type of quiz you would like to do?");
				con.println("(Linear, Algebra)");
				String strType = con.readLine();
				con.clear();
				
				if(strType.equalsIgnoreCase("linear")){
					TextInputFile linear = new TextInputFile("linear.txt");
					
					// Initialization
					strQuestion = "";
					intAnswer = 0;
					dblAnswer = 0.0;
					strAnswer = "";
					intCorrectAnswer = 0;
					
					while(linear.eof() == false){
						strQuestion = linear.readLine();
						intAnswer = linear.readInt();
						dblAnswer = linear.readDouble();
						strAnswer = linear.readLine();
					}
					
					con.println("Question: ");
					con.println(strQuestion);
					String strUAnswer = con.readLine();
					
					if(strUAnswer.equalsIgnoreCase(strAnswer) || 
					Integer.parseInt(strUAnswer) == intAnswer || 
					Double.parseDouble(strUAnswer) == dblAnswer){
						
						con.println("Congrats! You got the correct answer.");
						intCorrectAnswer += 1;
						
					} else {
						con.println("You got the wrong answer. It should be 2 or 2.0, or two.");
					}
					
					con.clear();
					
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
						
						if(strResponse.equalsIgnoreCase(strAnswer) ||  
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
			}
		}
	}
}
