import arc.*;

public class MathTrainingTests{
	public static void linearTest(Console con){
		TextInputFile linear = new TextInputFile("linear.txt");

		// Creating an array to randomize the questions
		String strLinear[][];

		// Variables
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		int intQuestions = 0;
		int intCorrectAnswer = 0;
		int intNumQuestions = 0;
		double dblPercentage = 0.0;
		

		while(linear.eof() == false){
						
			strQuestion = linear.readLine();
			strAnswer1 = linear.readLine();
			strAnswer2 = linear.readLine();
			strAnswer3 = linear.readLine();
			intQuestions += 1;
		}
		
		linear.close();
					
		strLinear = new String[intQuestions][5];

		System.out.println("Continue");
		
		linear = new TextInputFile("linear.txt");

		while(linear.eof() == false){
			String strRandomNum;
			
			int intRow;
			
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
		String strTempRandomNum;
		int intRow2;
		int intRow3;
	
		
		for(intRow3 = 0; intRow3 < intQuestions - 1; intRow3++){
			
			for(intRow2 = 0; intRow2 < intQuestions - 1 - intRow3; intRow2++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strLinear[intRow2][4]) > Integer.parseInt(strLinear[intRow2 + 1][4])){
					
					// Take the left item
					strTempQuestion = strLinear[intRow2][0];
					strTempAns1 = strLinear[intRow2][1];
					strTempAns2 = strLinear[intRow2][2];
					strTempAns3 = strLinear[intRow2][3];
					
					// Right item moves to the left
					strLinear[intRow2][0] = strLinear[intRow2 + 1][0];
					strLinear[intRow2][1] = strLinear[intRow2 + 1][1];
					strLinear[intRow2][2] = strLinear[intRow2 + 1][2];
					strLinear[intRow2][3] = strLinear[intRow2 + 1][3];
					
					// Put temporary value on the right
					strLinear[intRow2 + 1][0] = strTempQuestion;
					strLinear[intRow2 + 1][1] = strTempAns1;
					strLinear[intRow2 + 1][2] = strTempAns2;
					strLinear[intRow2 + 1][3] = strTempAns3;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
		
			con.println("Question: ");
			con.println(strLinear[intLoop][0]);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strLinear[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strLinear[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strLinear[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				intCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strLinear[intLoop][1] + ", " + strLinear[intLoop][2] + ", " + strLinear[intLoop][3]);
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
	
	
	public static void algebraTest(Console con){
		TextInputFile algebra = new TextInputFile("algebra.txt");

		// Creating an array to randomize the questions
		String strAlgebra[][];

		// Variables
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		int intQuestions = 0;
		int intCorrectAnswer = 0;
		int intNumQuestions = 0;
		double dblPercentage = 0.0;
		

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
		String strTempRandomNum;
		int intRow2;
		int intRow3;
	
		
		for(intRow3 = 0; intRow3 < intQuestions - 1; intRow3++){
			
			for(intRow2 = 0; intRow2 < intQuestions - 1 - intRow3; intRow2++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strAlgebra[intRow2][4]) > Integer.parseInt(strAlgebra[intRow2 + 1][4])){
					
					// Take the left item
					strTempQuestion = strAlgebra[intRow2][0];
					strTempAns1 = strAlgebra[intRow2][1];
					strTempAns2 = strAlgebra[intRow2][2];
					strTempAns3 = strAlgebra[intRow2][3];
					
					// Right item moves to the left
					strAlgebra[intRow2][0] = strAlgebra[intRow2 + 1][0];
					strAlgebra[intRow2][1] = strAlgebra[intRow2 + 1][1];
					strAlgebra[intRow2][2] = strAlgebra[intRow2 + 1][2];
					strAlgebra[intRow2][3] = strAlgebra[intRow2 + 1][3];
					
					// Put temporary value on the right
					strAlgebra[intRow2 + 1][0] = strTempQuestion;
					strAlgebra[intRow2 + 1][1] = strTempAns1;
					strAlgebra[intRow2 + 1][2] = strTempAns2;
					strAlgebra[intRow2 + 1][3] = strTempAns3;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
		
			con.println("Question: ");
			con.println(strAlgebra[intLoop][0]);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strAlgebra[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strAlgebra[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strAlgebra[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				intCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strAlgebra[intLoop][1] + ", " + strAlgebra[intLoop][2] + ", " + strAlgebra[intLoop][3]);
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
	
	public static void patternsTest(Console con){
		TextInputFile patterns = new TextInputFile("patterns.txt");

		// Creating an array to randomize the questions
		String strPatterns[][];

		// Variables
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		int intQuestions = 0;
		int intCorrectAnswer = 0;
		int intNumQuestions = 0;
		double dblPercentage = 0.0;
		

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
		int intRow2;
		int intRow3;
	
		
		for(intRow3 = 0; intRow3 < intQuestions - 1; intRow3++){
			
			for(intRow2 = 0; intRow2 < intQuestions - 1 - intRow3; intRow2++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strPatterns[intRow2][4]) > Integer.parseInt(strPatterns[intRow2 + 1][4])){
					
					// Take the left item
					strTempQuestion = strPatterns[intRow2][0];
					strTempAns1 = strPatterns[intRow2][1];
					strTempAns2 = strPatterns[intRow2][2];
					strTempAns3 = strPatterns[intRow2][3];
					
					// Right item moves to the left
					strPatterns[intRow2][0] = strPatterns[intRow2 + 1][0];
					strPatterns[intRow2][1] = strPatterns[intRow2 + 1][1];
					strPatterns[intRow2][2] = strPatterns[intRow2 + 1][2];
					strPatterns[intRow2][3] = strPatterns[intRow2 + 1][3];
					
					// Put temporary value on the right
					strPatterns[intRow2 + 1][0] = strTempQuestion;
					strPatterns[intRow2 + 1][1] = strTempAns1;
					strPatterns[intRow2 + 1][2] = strTempAns2;
					strPatterns[intRow2 + 1][3] = strTempAns3;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
		
			con.println("Question: ");
			con.println(strPatterns[intLoop][0]);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strPatterns[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strPatterns[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strPatterns[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				intCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strPatterns[intLoop][1] + ", " + strPatterns[intLoop][2] + ", " + strPatterns[intLoop][3]);
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
	
		public static void areaTest(Console con){
		TextInputFile area = new TextInputFile("area.txt");

		// Creating an array to randomize the questions
		String strArea[][];

		// Variables
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		int intQuestions = 0;
		int intCorrectAnswer = 0;
		int intNumQuestions = 0;
		double dblPercentage = 0.0;
		

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
		
		area = new TextInputFile("patterns.txt");

		while(area.eof() == false){
			String strRandomNum;
			
			int intRow;
			
			for(intRow = 0; intRow < intQuestions; intRow++){
				
				strRandomNum = Integer.toString((int)(Math.random() * 100 + 1));
				
				strArea[intRow][0] = area.readLine();
				strArea[intRow][1] = area.readLine();
				strArea[intRow][2] = area.readLine();
				strArea[intRow][3] = area.readLine();
				strArea[intRow][4] = strRandomNum;
			}
		}
		
		area.close();
		
		// Bubble Sort 
		String strTempQuestion;
		String strTempAns1;
		String strTempAns2;
		String strTempAns3;
		String strTempRandomNum;
		int intRow2;
		int intRow3;
	
		
		for(intRow3 = 0; intRow3 < intQuestions - 1; intRow3++){
			
			for(intRow2 = 0; intRow2 < intQuestions - 1 - intRow3; intRow2++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strArea[intRow2][4]) > Integer.parseInt(strArea[intRow2 + 1][4])){
					
					// Take the left item
					strTempQuestion = strArea[intRow2][0];
					strTempAns1 = strArea[intRow2][1];
					strTempAns2 = strArea[intRow2][2];
					strTempAns3 = strArea[intRow2][3];
					
					// Right item moves to the left
					strArea[intRow2][0] = strArea[intRow2 + 1][0];
					strArea[intRow2][1] = strArea[intRow2 + 1][1];
					strArea[intRow2][2] = strArea[intRow2 + 1][2];
					strArea[intRow2][3] = strArea[intRow2 + 1][3];
					
					// Put temporary value on the right
					strArea[intRow2 + 1][0] = strTempQuestion;
					strArea[intRow2 + 1][1] = strTempAns1;
					strArea[intRow2 + 1][2] = strTempAns2;
					strArea[intRow2 + 1][3] = strTempAns3;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
		
			con.println("Question: ");
			con.println(strArea[intLoop][0]);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strArea[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strArea[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strArea[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				intCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strArea[intLoop][1] + ", " + strArea[intLoop][2] + ", " + strArea[intLoop][3]);
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
	




