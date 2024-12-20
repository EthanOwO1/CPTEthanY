import arc.*;

public class MathTrainingGame{
	public static void main(String[] args){
		Console con = new Console("Math Training Game");
		
		// Variables
		String strQuestion;
		int intAnswer;
		double dblAnswer;
		String strAnswer;
		int intCorrectAnswer;
		
		while(true){
			con.println("Welcome to Math Training Game");
			con.println("What would you like to do? (Play game, Leaderboard, Help, Quit) ");
			String strDecision = con.readLine();
			
			con.clear();
			
			
			if(strDecision.equalsIgnoreCase("quit")){
				con.println("Thank you for playing! See you next time!");
				con.sleep(3000);
				con.closeConsole();
				
			} else if(strDecision.equalsIgnoreCase("leaderboard")){
				con.println("This is the leaderboard");
				con.println("Do you want to go back to main menu?");
				String strBack = con.readLine();
				con.clear();
				
				
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
				
			} else {
				con.println("Please enter your name: ");
				String strName = con.readLine();
				con.clear();
				
				con.println("Hi " + strName);
				con.sleep(1000);
				con.println("Welcome to our game! Please choose which type of quiz you would like to do?");
				con.println("(Linear)");
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
			}
		}
	}
}
