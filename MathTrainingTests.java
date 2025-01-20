import arc.*;
import java.awt.image.*;


public class MathTrainingTests{
	public static void linearTest(Console con){
		TextInputFile linear = new TextInputFile("linear.txt");


		// Creating an array to store all of the data from the linear file
		String strLinear[][];

		// Variables and Initialization
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		String strName = "";
		int intQuestions = 0;
		double dblCorrectAnswer = 0.0;
		double dblNumQuestions = 0.0;
		double dblPercentage = 0.0;
		
		// Retrieving strName from the main program
		strName = MathTrainingGame.strName;

		// Counting the number of questions 
		while(linear.eof() == false){
						
			strQuestion = linear.readLine();
			strAnswer1 = linear.readLine();
			strAnswer2 = linear.readLine();
			strAnswer3 = linear.readLine();
			intQuestions += 1;
		}
		linear.close();
		
		// Create an array based on the number of questions
		strLinear = new String[intQuestions][5];
		
		
		linear = new TextInputFile("linear.txt");
		while(linear.eof() == false){
			String strRandomNum;
			
			int intRow;
			
			// Storing all the data in the designated row/column
			for(intRow = 0; intRow < intQuestions; intRow++){
				
				strRandomNum = Integer.toString((int)(Math.random() * 100 + 1));
				
				strLinear[intRow][0] = linear.readLine();
				strLinear[intRow][1] = linear.readLine();
				strLinear[intRow][2] = linear.readLine();
				strLinear[intRow][3] = linear.readLine();
				strLinear[intRow][4] = strRandomNum;
			}
		}
		
		linear.close();
		
		// Bubble Sort 
		String strTempQuestion;
		String strTempAns1;
		String strTempAns2;
		String strTempAns3;
		String strRandom;
		int intRow;
		int intRow2;
	
		
		for(intRow2 = 0; intRow2 < intQuestions - 1; intRow2++){
			
			for(intRow = 0; intRow < intQuestions - 1 - intRow2; intRow++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strLinear[intRow][4]) > Integer.parseInt(strLinear[intRow + 1][4])){
					
					// Take the left item
					strTempQuestion = strLinear[intRow][0];
					strTempAns1 = strLinear[intRow][1];
					strTempAns2 = strLinear[intRow][2];
					strTempAns3 = strLinear[intRow][3];
					strRandom = strLinear[intRow][4];
					
					// Right item moves to the left
					strLinear[intRow][0] = strLinear[intRow + 1][0];
					strLinear[intRow][1] = strLinear[intRow + 1][1];
					strLinear[intRow][2] = strLinear[intRow + 1][2];
					strLinear[intRow][3] = strLinear[intRow + 1][3];
					strLinear[intRow][4] = strLinear[intRow + 1][4];
					
					// Put temporary value on the right
					strLinear[intRow + 1][0] = strTempQuestion;
					strLinear[intRow + 1][1] = strTempAns1;
					strLinear[intRow + 1][2] = strTempAns2;
					strLinear[intRow + 1][3] = strTempAns3;
					strLinear[intRow + 1][4] = strRandom;
				}
			}
		}
							
		int intLoop;
		
		// Starting the test
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
			
			con.println(strName + "		Linear		" + dblPercentage + "%");
			con.println();
			
			con.println("Question: ");
			printWrappedText(con, strLinear[intLoop][0], 80);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strLinear[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strLinear[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strLinear[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				dblCorrectAnswer += 1;

				con.sleep(3000);

								
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strLinear[intLoop][1] + ", " + strLinear[intLoop][2] + ", " + strLinear[intLoop][3]);
				con.sleep(3000);
			}
			dblNumQuestions += 1;
			dblPercentage = Math.round(((dblCorrectAnswer / dblNumQuestions) * 100) * 100) / 100;

			con.clear();
		}
				
		// Printing the name to the leaderboard
		TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
		
		leaderboard.println(strName);
		leaderboard.println("Linear");
		leaderboard.println(dblPercentage);
		
		
		// Displaying final results
		con.println("Final Results: ");
		con.println("Name:              " + strName);
		con.println("Test type: 	    Linear");
		con.println("Win Percentage: " + dblPercentage + "%");
		
		con.sleep(2000);
		con.println("Thanks for playing!");
		con.println("Return back to main menu?");
		String strBack = con.readLine();
		con.clear();
	}
	
	
	public static void algebraTest(Console con){
		TextInputFile algebra = new TextInputFile("algebra.txt");

		// Creating an array to randomize the questions
		String strAlgebra[][];

		// Variables and Initialization
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		String strName = "";
		int intQuestions = 0;
		double dblCorrectAnswer = 0.0;
		double dblNumQuestions = 0.0;
		double dblPercentage = 0.0;
		
		// Retrieving the data stored in strName
		strName = MathTrainingGame.strName;

		while(algebra.eof() == false){
						
			strQuestion = algebra.readLine();
			strAnswer1 = algebra.readLine();
			strAnswer2 = algebra.readLine();
			strAnswer3 = algebra.readLine();
			intQuestions += 1;
		}
		
		algebra.close();
					
		strAlgebra = new String[intQuestions][5];

		System.out.println("Continue");
		
		algebra = new TextInputFile("algebra.txt");

		while(algebra.eof() == false){
			String strRandomNum;
			
			int intRow;
			
			for(intRow = 0; intRow < intQuestions; intRow++){
				
				strRandomNum = Integer.toString((int)(Math.random() * 100 + 1));
				
				strAlgebra[intRow][0] = algebra.readLine();
				strAlgebra[intRow][1] = algebra.readLine();
				strAlgebra[intRow][2] = algebra.readLine();
				strAlgebra[intRow][3] = algebra.readLine();
				strAlgebra[intRow][4] = strRandomNum;
			}
		}
		
		algebra.close();
		
		// Bubble Sort 
		String strTempQuestion;
		String strTempAns1;
		String strTempAns2;
		String strTempAns3;
		String strRandom;
		int intRow;
		int intRow2;
	
		
		for(intRow2 = 0; intRow2 < intQuestions - 1; intRow2++){
			
			for(intRow = 0; intRow < intQuestions - 1 - intRow2; intRow++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strAlgebra[intRow][4]) > Integer.parseInt(strAlgebra[intRow + 1][4])){
					
					// Take the left item
					strTempQuestion = strAlgebra[intRow][0];
					strTempAns1 = strAlgebra[intRow][1];
					strTempAns2 = strAlgebra[intRow][2];
					strTempAns3 = strAlgebra[intRow][3];
					strRandom = strAlgebra[intRow][4];
					
					// Right item moves to the left
					strAlgebra[intRow][0] = strAlgebra[intRow + 1][0];
					strAlgebra[intRow][1] = strAlgebra[intRow + 1][1];
					strAlgebra[intRow][2] = strAlgebra[intRow + 1][2];
					strAlgebra[intRow][3] = strAlgebra[intRow + 1][3];
					strAlgebra[intRow][4] = strAlgebra[intRow + 1][4];
					
					// Put temporary value on the right
					strAlgebra[intRow + 1][0] = strTempQuestion;
					strAlgebra[intRow + 1][1] = strTempAns1;
					strAlgebra[intRow + 1][2] = strTempAns2;
					strAlgebra[intRow + 1][3] = strTempAns3;
					strAlgebra[intRow + 1][4] = strRandom;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
			
			con.println(strName + "		Algebra		" + dblPercentage + "%");
			con.println();
			
			con.println("Question: ");
			printWrappedText(con, strAlgebra[intLoop][0], 80);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strAlgebra[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strAlgebra[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strAlgebra[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				dblCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strAlgebra[intLoop][1] + ", " + strAlgebra[intLoop][2] + ", " + strAlgebra[intLoop][3]);
				con.sleep(3000);
			}
			dblNumQuestions += 1;
			dblPercentage = Math.round(((dblCorrectAnswer / dblNumQuestions) * 100) * 100) / 100;

			con.clear();
		}	
		
		// Printing the results to the leaderboard
		TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
		
		leaderboard.println(strName);
		leaderboard.println("Algebra");
		leaderboard.println(dblPercentage);
		
		
		// Displaying final results
		con.println("Final Results: ");
		con.println("Name:              " + strName);
		con.println("Test type: 	    Algebra");
		con.println("Win Percentage: " + dblPercentage + "%");
		
		con.sleep(2000);
		con.println("Thanks for playing!");
		con.println("Return back to main menu?");
		String strBack = con.readLine();
		con.clear();
		
	}
	
	public static void patternsTest(Console con){
		TextInputFile patterns = new TextInputFile("patterns.txt");

		// Creating an array to randomize the questions
		String strPatterns[][];

		// Variables
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		String strName = "";
		int intQuestions = 0;
		double dblCorrectAnswer = 0.0;
		double dblNumQuestions = 0.0;
		double dblPercentage = 0.0;
		
		// Retrieving the data stored in strName
		strName = MathTrainingGame.strName;

		while(patterns.eof() == false){
						
			strQuestion = patterns.readLine();
			strAnswer1 = patterns.readLine();
			strAnswer2 = patterns.readLine();
			strAnswer3 = patterns.readLine();
			intQuestions += 1;
		}
		
		patterns.close();
					
		strPatterns = new String[intQuestions][5];

		System.out.println("Continue");
		
		patterns = new TextInputFile("patterns.txt");

		while(patterns.eof() == false){
			String strRandomNum;
			
			int intRow;
			
			for(intRow = 0; intRow < intQuestions; intRow++){
				
				strRandomNum = Integer.toString((int)(Math.random() * 100 + 1));
				
				strPatterns[intRow][0] = patterns.readLine();
				strPatterns[intRow][1] = patterns.readLine();
				strPatterns[intRow][2] = patterns.readLine();
				strPatterns[intRow][3] = patterns.readLine();
				strPatterns[intRow][4] = strRandomNum;
			}
		}
		
		patterns.close();
		
		// Bubble Sort 
		String strTempQuestion;
		String strTempAns1;
		String strTempAns2;
		String strTempAns3;
		String strTempRandomNum;
		String strRandom;
		int intRow;
		int intRow2;
	
		
		for(intRow2 = 0; intRow2 < intQuestions - 1; intRow2++){
			
			for(intRow = 0; intRow < intQuestions - 1 - intRow2; intRow++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strPatterns[intRow][4]) > Integer.parseInt(strPatterns[intRow + 1][4])){
					
					// Take the left item
					strTempQuestion = strPatterns[intRow][0];
					strTempAns1 = strPatterns[intRow][1];
					strTempAns2 = strPatterns[intRow][2];
					strTempAns3 = strPatterns[intRow][3];
					strRandom = strPatterns[intRow][4];
					
					// Right item moves to the left
					strPatterns[intRow][0] = strPatterns[intRow + 1][0];
					strPatterns[intRow][1] = strPatterns[intRow + 1][1];
					strPatterns[intRow][2] = strPatterns[intRow + 1][2];
					strPatterns[intRow][3] = strPatterns[intRow + 1][3];
					strPatterns[intRow][4] = strPatterns[intRow + 1][4];
					
					// Put temporary value on the right
					strPatterns[intRow + 1][0] = strTempQuestion;
					strPatterns[intRow + 1][1] = strTempAns1;
					strPatterns[intRow + 1][2] = strTempAns2;
					strPatterns[intRow + 1][3] = strTempAns3;
					strPatterns[intRow + 1][4] = strRandom;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
			
			con.println(strName + "		Patterns		" + dblPercentage + "%");
			con.println();
			
			con.println("Question: ");
			printWrappedText(con, strPatterns[intLoop][0], 80);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strPatterns[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strPatterns[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strPatterns[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				dblCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strPatterns[intLoop][1] + ", " + strPatterns[intLoop][2] + ", " + strPatterns[intLoop][3]);
				con.sleep(3000);
			}
			dblNumQuestions += 1;
			dblPercentage = Math.round(((dblCorrectAnswer / dblNumQuestions) * 100) * 100) / 100;

			con.clear();
		}	
		
		// Printing the results to the leaderboard
		TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
		
		leaderboard.println(strName);
		leaderboard.println("Patterns");
		leaderboard.println(dblPercentage);
		
		
		// Displaying final results
		con.println("Final Results: ");
		con.println("Name:              " + strName);
		con.println("Test type: 	    Patterns");
		con.println("Win Percentage: " + dblPercentage + "%");
		
		con.sleep(2000);
		con.println("Thanks for playing!");
		con.println("Return back to main menu?");
		String strBack = con.readLine();
		con.clear();
	}	
	
	public static void areaTest(Console con){
		TextInputFile area = new TextInputFile("area.txt");

		// Creating an array to randomize the questions
		String strArea[][];

		// Variables
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		String strName = "";
		int intQuestions = 0;
		double dblCorrectAnswer = 0.0;
		double dblNumQuestions = 0.0;
		double dblPercentage = 0.0;
		
		// Retrieving the data stored in strName
		strName = MathTrainingGame.strName;

		while(area.eof() == false){
						
			strQuestion = area.readLine();
			strAnswer1 = area.readLine();
			strAnswer2 = area.readLine();
			strAnswer3 = area.readLine();
			intQuestions += 1;
		}
		
		area.close();
					
		strArea = new String[intQuestions][5];

		System.out.println("Continue");
		
		area = new TextInputFile("area.txt");

		while(area.eof() == false){			
			int intRow;
			
			for(intRow = 0; intRow < intQuestions; intRow++){
				
				strArea[intRow][0] = area.readLine();
				strArea[intRow][1] = area.readLine();
				strArea[intRow][2] = area.readLine();
				strArea[intRow][3] = area.readLine();
				strArea[intRow][4] = Integer.toString((int)(Math.random() * 100 + 1));
								
			}
		}
		
		area.close();
		
		// Bubble Sort 
		String strTempQuestion;
		String strTempAns1;
		String strTempAns2;
		String strTempAns3;
		String strTempRandomNum;
		String strRandom;
		int intRow;
		int intRow2;
	
		
		for(intRow2 = 0; intRow2 < intQuestions - 1; intRow2++){
			
			for(intRow = 0; intRow < intQuestions - 1 - intRow2; intRow++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strArea[intRow][4]) > Integer.parseInt(strArea[intRow + 1][4])){
					
					// Take the left item
					strTempQuestion = strArea[intRow][0];
					strTempAns1 = strArea[intRow][1];
					strTempAns2 = strArea[intRow][2];
					strTempAns3 = strArea[intRow][3];
					strRandom = strArea[intRow][4];

					
					// Right item moves to the left
					strArea[intRow][0] = strArea[intRow + 1][0];
					strArea[intRow][1] = strArea[intRow + 1][1];
					strArea[intRow][2] = strArea[intRow + 1][2];
					strArea[intRow][3] = strArea[intRow + 1][3];
					strArea[intRow][4] = strArea[intRow + 1][4];
					
					// Put temporary value on the right
					strArea[intRow + 1][0] = strTempQuestion;
					strArea[intRow + 1][1] = strTempAns1;
					strArea[intRow + 1][2] = strTempAns2;
					strArea[intRow + 1][3] = strTempAns3;
					strArea[intRow + 1][4] = strRandom;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
			
			con.println(strName + "		Area		" + dblPercentage + "%");
			con.println();
			
			con.println("Question: ");
			printWrappedText(con, strArea[intLoop][0], 80);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strArea[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strArea[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strArea[intLoop][3])){
			
				con.println("Congrats! You got the correct answer.");
				dblCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strArea[intLoop][1] + ", " + strArea[intLoop][2] + ", " + strArea[intLoop][3]);
				con.sleep(3000);
			}
			dblNumQuestions += 1;
			dblPercentage = Math.round(((dblCorrectAnswer / dblNumQuestions) * 100) * 100) / 100;

			con.clear();
		}	
		
		// Printing the results to the leaderboard
		TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
		
		leaderboard.println(strName);
		leaderboard.println("Area");
		leaderboard.println(dblPercentage);
		
		
		// Displaying final results
		con.println("Final Results: ");
		con.println("Name:              " + strName);
		con.println("Test type: 	    Area");
		con.println("Win Percentage: " + dblPercentage + "%");
		
		con.sleep(2000);
		con.println("Thanks for playing!");
		con.println("Return back to main menu?");
		String strBack = con.readLine();
		con.clear();
	}
	
	    public static void printWrappedText(Console con, String text, int maxLineWidth) {
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
			
            // Check if adding the next word would exceed the maximum line width
            if (currentLine.length() + word.length() + 1 > maxLineWidth) {
                con.println(currentLine.toString().trim()); 
                currentLine = new StringBuilder();
            }
            currentLine.append(word).append(" "); 
        }
 
        if (currentLine.length() > 0) {
            con.println(currentLine.toString().trim());
        }
    }
	
}
	




